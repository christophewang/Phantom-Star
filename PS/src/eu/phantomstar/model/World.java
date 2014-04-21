package eu.phantomstar.model;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Array;

import eu.phantomstar.controller.InputHandler;

public class World {
	
	private Score score;
	private Ship ship;
	
	private Array<Bullet> bullets;
	private Iterator<Bullet> bulletsIterator;
	private Bullet bullet;
	
	private Array<Meteor> meteors;
	private Iterator<Meteor> meteorsIterator;
	private Meteor meteor;
	
	private Array<Enemy> enemies;
	private Iterator<Enemy> enemiesIterator;
	private Enemy enemy;
	
	private WorldGenerator worldGenerator;
	
	public World() {
		score = new Score();
		worldGenerator = new WorldGenerator();
		ship = worldGenerator.getShip();
		Audio.playMusic(true);
		Gdx.input.setInputProcessor(new GestureDetector(new InputHandler(this)));
	}
	
	public void update(float delta, OrthographicCamera camera) {

		if (ship.isAlive()) {
			ship.update();
			worldGenerator.generate(delta, camera);
			meteors = worldGenerator.getMeteors();
			enemies = worldGenerator.getEnemies();
			bullets = worldGenerator.getBullets();
			checkBulletCollision(delta);
			checkMeteorCollision(delta);
			checkEnemyCollision(delta);
		}

	}
	
	public void checkMeteorCollision(float delta) {
		meteorsIterator = meteors.iterator();
		while (meteorsIterator.hasNext()) {
			meteor = meteorsIterator.next();
			meteor.update(delta);
			if (ship.getBounds().overlaps(meteor.getBounds())) {
				Audio.shipExplosion.play();
				ship.setAlive(false);
			}
			if (meteor.getBounds().y < 0) {
				meteorsIterator.remove();
				score.setScore(score.getScore() + 200);
				score.update();
			}
			bulletsIterator = bullets.iterator();
			while (bulletsIterator.hasNext()) {
				bullet = bulletsIterator.next();
				if (meteor.getBounds().overlaps(bullet.getBounds())) {
					bulletsIterator.remove();
				}
			}
		}
	}
	
	public void checkEnemyCollision(float delta) {
		enemiesIterator = enemies.iterator();
		while (enemiesIterator.hasNext()) {
			enemy = enemiesIterator.next();
			enemy.update(delta);
			if (ship.getBounds().overlaps(enemy.getBounds())) {
				ship.setAlive(false);
				Audio.shipExplosion.play();
			}
			if (enemy.getBounds().y < 0) {
				enemiesIterator.remove();
			}
			bulletsIterator = bullets.iterator();
			while (bulletsIterator.hasNext()) {
				bullet = bulletsIterator.next();
				if (enemy.getBounds().overlaps(bullet.getBounds())) {
					bulletsIterator.remove();
					enemiesIterator.remove();
					Audio.explosion.play();
					score.setScore(score.getScore() + 1000);
					score.update();
				}
			}
		}
	}
	
	public void checkBulletCollision(float delta) {
		bulletsIterator = bullets.iterator();
		while (bulletsIterator.hasNext()) {
			bullet = bulletsIterator.next();
			bullet.update(delta);
			enemiesIterator = enemies.iterator();
			meteorsIterator = meteors.iterator();
			if (bullet.getBounds().y > worldGenerator.getHeight()) {
				bulletsIterator.remove();
			}
		}
	}
	
	public Ship getShip() {
		return ship;
	}

	public Array<Bullet> getBullets() {
		return bullets;
	}
	
	public Array<Meteor> getMeteors() {
		return meteors;
	}
	
	public Array<Enemy> getEnemies() {
		return enemies;
	}

	public Score getScore() {
		return score;
	}
}
