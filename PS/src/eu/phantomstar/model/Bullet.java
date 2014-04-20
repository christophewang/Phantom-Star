package eu.phantomstar.model;

import com.badlogic.gdx.math.Vector2;

public class Bullet extends MoveableEntity {

	public Bullet(Vector2 position, float width, float height, float speed, Vector2 velocity) {
		super(position, width, height, speed, velocity);
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta * speed));
		bounds.x = position.x;
		bounds.y = position.y;
	}
}
