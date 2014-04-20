package eu.phantomstar.model;

import com.badlogic.gdx.math.Vector2;

public class Ship extends MoveableEntity {

	private boolean alive;
	
	public Ship(Vector2 position, float width, float height, float speed,
			Vector2 velocity) {
		super(position, width, height, speed, velocity);
		alive = true;
	}
	
	public void update() {
		position.add(velocity.cpy().scl(speed));
		bounds.x = position.x;
		bounds.y = position.y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
