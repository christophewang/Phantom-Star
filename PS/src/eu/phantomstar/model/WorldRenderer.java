package eu.phantomstar.model;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import eu.phantomstar.PhantomStar;
import eu.phantomstar.dialog.GameOverDialog;

public class WorldRenderer {
	
	private PhantomStar game;
	private World world;
	private SpriteBatch spriteBatch;
	private Sprite backgroundSprite;
	private Ship ship;
	private Background background;
	private ShapeRenderer shapeRenderer;

	private Array<Bullet> bullets;
	private Iterator<Bullet> bulletsIterator;
	private Bullet bullet;
	
	private Array<Meteor> meteors;
	private Iterator<Meteor> meteorsIterator;
	private Meteor meteor;
	
	private Array<Enemy> enemies;
	private Iterator<Enemy> enemiesIterator;
	private Enemy enemy;
	
	private Score score;

	private Stage stage;
	private GameOverDialog gameoverDialog;
	
	public WorldRenderer(PhantomStar game, World world) {
		this.game = game;
		this.world = world;
		background = new Background();
		spriteBatch = new SpriteBatch();
		backgroundSprite = new Sprite(Asset.backgroundTexture, 0, 0, 
				Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		shapeRenderer = new ShapeRenderer();
		
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
	}
	
	public void render(OrthographicCamera camera) {
		ship = world.getShip();
		bullets = world.getBullets();
		meteors = world.getMeteors();
		enemies = world.getEnemies();
		score = world.getScore();

		spriteBatch.setProjectionMatrix(camera.combined);
		background.update();
		backgroundSprite.setV(background.getScrollTimer());
		backgroundSprite.setV2(background.getScrollTimer() - 1);
		score.getBitmapFontCache().setPosition(0, Gdx.graphics.getHeight());
		spriteBatch.begin();
		backgroundSprite.draw(spriteBatch);
		score.getBitmapFontCache().draw(spriteBatch);
		if (ship.isAlive()) {
			drawGameWorld();
		} else {
			drawGameOverDialog();
		}
		spriteBatch.end();
		
		if (PhantomStar.DEBUG) {
			shapeRenderer.setProjectionMatrix(camera.combined);
			shapeRenderer.begin(ShapeType.Line);
			shapeRenderer.setColor(Color.RED);
			shapeRenderer.rect(ship.getBounds().x, ship.getBounds().y, 
					ship.getBounds().width, ship.getBounds().height);
			meteorsIterator = meteors.iterator();
			while (meteorsIterator.hasNext()) {
				meteor = meteorsIterator.next();
				shapeRenderer.rect(meteor.getBounds().x, meteor.getBounds().y, 
						meteor.getBounds().width, meteor.getBounds().height);
			}
			enemiesIterator = enemies.iterator();
			while (enemiesIterator.hasNext()) {
				enemy = enemiesIterator.next();
				shapeRenderer.rect(enemy.getBounds().x, enemy.getBounds().y, 
						enemy.getBounds().width, enemy.getBounds().height);
			}
			shapeRenderer.end();
		}
	}
	
	public void drawGameWorld() {
		spriteBatch.draw(Asset.shipTexture, ship.getPosition().x, 
				ship.getPosition().y, ship.getWidth()/2, ship.getHeight()/2, 
				ship.getWidth(), ship.getHeight(), 1, 1, 0, 0, 0, 
				Asset.shipTexture.getWidth(), 
				Asset.shipTexture.getHeight(), false, false);
		bulletsIterator = bullets.iterator();
		while (bulletsIterator.hasNext()) {
			bullet = bulletsIterator.next();
			spriteBatch.draw(Asset.bulletTexture, bullet.getPosition().x, 
					bullet.getPosition().y, bullet.getWidth()/2, bullet.getHeight()/2,
					bullet.getWidth(), bullet.getHeight(), 1, 1, 0, 0, 0, 
					Asset.bulletTexture.getWidth(), 
					Asset.bulletTexture.getHeight(), false, false);
		}
		meteorsIterator = meteors.iterator();
		while (meteorsIterator.hasNext()) {
			meteor = meteorsIterator.next();
			spriteBatch.draw(Asset.meteorMap.get(meteor.getType()), meteor.getPosition().x, 
					meteor.getPosition().y, meteor.getWidth()/2, meteor.getHeight()/2, 
					meteor.getWidth(), meteor.getHeight(), 1, 1, meteor.getRotation(), 
					false);
		}
		enemiesIterator = enemies.iterator();
		while (enemiesIterator.hasNext()) {
			enemy = enemiesIterator.next();
			spriteBatch.draw(Asset.enemyMap.get(enemy.getType()), enemy.getPosition().x, 
					enemy.getPosition().y, enemy.getWidth()/2, enemy.getHeight()/2, 
					enemy.getWidth(), enemy.getHeight(), 1, 1, 0);
		}
	}
	
	public void drawGameOverDialog() {
		if (gameoverDialog == null) {
			gameoverDialog = new GameOverDialog(game, "Game Over");
			gameoverDialog.text("Score " + Integer.toString(score.getScore()));
			gameoverDialog.button("Retry", "retry");
			gameoverDialog.button("Exit", "exit");
			gameoverDialog.show(stage);
		}

		Gdx.input.setInputProcessor(stage);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	public void dispose() {
		spriteBatch.dispose();
		shapeRenderer.dispose();
		stage.dispose();
	}
}
