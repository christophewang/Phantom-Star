package eu.phantomstar.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import eu.phantomstar.model.Ship;
import eu.phantomstar.model.World;

public class InputHandler implements GestureListener {
	
	private Ship ship;

	public InputHandler(World world) {
		ship = world.getShip();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		ship.getPosition().x += deltaX;
		ship.getPosition().y -= deltaY;
		if (ship.getPosition().x < 0) {
			ship.getPosition().x = 0;
		} 
		if (ship.getPosition().x > Gdx.graphics.getWidth() - ship.getWidth()) {
			ship.getPosition().x = Gdx.graphics.getWidth() - ship.getWidth();
		}
		if (ship.getPosition().y < 0) {
			ship.getPosition().y = 0;
		}
		if (ship.getPosition().y > Gdx.graphics.getHeight() - ship.getHeight()) {
			ship.getPosition().y = Gdx.graphics.getHeight() - ship.getHeight();
		}
		return true;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}
