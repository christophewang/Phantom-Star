package eu.phantomstar.model;

import com.badlogic.gdx.math.Vector2;

public abstract class MoveableEntity extends Entity {

	protected Vector2 velocity;
	protected float speed;
	
	public MoveableEntity(Vector2 position, float width, float height, float speed, Vector2 velocity) {
		super(position, width, height);
		this.speed = speed;
		this.velocity = velocity;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		return speed;
	}
}
