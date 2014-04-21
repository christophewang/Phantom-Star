package eu.phantomstar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import eu.phantomstar.model.Enemy.EnemyType;
import eu.phantomstar.model.Meteor.MeteorType;

public class WorldGenerator {

	private float width;
	private float height;
	private float scale;
	private float meteorScale;
	private float enemiesSpeed;
	private float meteorsSpeed;
	private Ship ship;
	private Vector3 bulletVector3;
	private Vector2 bulletVector2;
	private float bulletTimer;
	private float meteorTimer;
	private float enemyTimer;
	private Array<Bullet> bullets;
	private Array<Enemy> enemies;
	private Array<Meteor> meteors;
	private Rectangle oldBounds;
	private Rectangle newBounds;
	
	List<EnemyType> enemyTypes;
	List<MeteorType> meteorTypes;

	public WorldGenerator() {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		scale = height/1200;
		meteorScale = 1;
		enemiesSpeed = -500;
		meteorsSpeed = -500;
		ship = new Ship(new Vector2(width/2 - 
				Asset.shipTexture.getWidth()*scale/2, 0f), 
				Asset.shipTexture.getWidth()*scale, 
				Asset.shipTexture.getHeight()*scale, 
				0, new Vector2(0, 0));
		bullets = new Array<Bullet>();
		bulletVector2 = new Vector2();
		bulletVector3 = new Vector3();
		bulletTimer = 0;
		meteors = new Array<Meteor>();
		meteorTimer = 0;
		enemies = new Array<Enemy>();
		enemyTimer = 0;
		oldBounds = new Rectangle(0, 0, 0, 0);
		newBounds = new Rectangle(0, 0, 0, 0);
		
		enemyTypes = new ArrayList<Enemy.EnemyType>();
		Collections.addAll(enemyTypes, EnemyType.values());
		meteorTypes = new ArrayList<Meteor.MeteorType>();
		Collections.addAll(meteorTypes, MeteorType.values());
	}

	public void generate(float delta, OrthographicCamera camera) {
		generateBullet(delta, camera);
		generateMeteor(delta);
		generateEnemy(delta);
	}
	
	public void generateBullet(float delta, OrthographicCamera camera) {
		bulletTimer += delta;
		if (bulletTimer > 0.2) {
			bulletTimer = 0;
			bulletVector3.set(ship.getPosition().x, 0, 0);
			camera.unproject(bulletVector3);
			bulletVector2.set(bulletVector3.x, bulletVector3.y);
			bullets.add(new Bullet(new Vector2(ship.getPosition().x + ship.getWidth()/2 - 
					Asset.bulletTexture.getWidth()*scale/2, 
					ship.getPosition().y + ship.getHeight()), 
					Asset.bulletTexture.getWidth()*scale, 
					Asset.bulletTexture.getHeight()*scale*2, 1000, 
					new Vector2(bulletVector2.sub(ship.getPosition()).nor())));
			Audio.shoot.play();
		}
	}
	
	public float generateXPosition(float assetWidth, float assetHeight) {
		float tempX;
		do {
			tempX = MathUtils.random(width - assetWidth);
			newBounds.set(tempX, height, assetWidth, assetHeight);
		} while (newBounds.overlaps(oldBounds));
		oldBounds.x = newBounds.x;
		oldBounds.y = newBounds.y;
		oldBounds.width = newBounds.width;
		oldBounds.height = newBounds.height;
		return tempX;
	}
	
	private void generateMeteor(float delta) {
		meteorTimer += delta;
		if (meteorTimer > 0.8) {
			meteorTimer = 0;
			Collections.shuffle(meteorTypes);
			MeteorType type = meteorTypes.get(0);
			float x = generateXPosition(Asset.meteorMap.get(type).getRegionWidth()*meteorScale, 
					Asset.meteorMap.get(type).getRegionHeight()*meteorScale);
			meteors.add(new Meteor(new Vector2(x, height), 
					Asset.meteorMap.get(type).getRegionWidth()*meteorScale, 
					Asset.meteorMap.get(type).getRegionHeight()*meteorScale, 
					1, 100, new Vector2(0, meteorsSpeed*meteorScale), type));
		}
	}
	
	public void generateEnemy(float delta) {
		enemyTimer += delta;
		if (enemyTimer > 0.5) {
			enemyTimer = 0;
			Collections.shuffle(enemyTypes);
			EnemyType type = enemyTypes.get(0);
			float x = generateXPosition(Asset.enemyMap.get(type).getRegionWidth()*scale, 
					Asset.enemyMap.get(type).getRegionHeight()*scale);
			enemies.add(new Enemy(new Vector2(x, height), 
					Asset.enemyMap.get(type).getRegionWidth()*scale, 
					Asset.enemyMap.get(type).getRegionHeight()*scale, 
					1, new Vector2(0, enemiesSpeed*scale), type));
		}
	}
	
	public float getHeight() {
		return height;
	}

	public Ship getShip() {
		return ship;
	}

	public Array<Bullet> getBullets() {
		return bullets;
	}

	public Array<Enemy> getEnemies() {
		return enemies;
	}

	public Array<Meteor> getMeteors() {
		return meteors;
	}
}
