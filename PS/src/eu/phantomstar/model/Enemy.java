package eu.phantomstar.model;

import com.badlogic.gdx.math.Vector2;

public class Enemy extends MoveableEntity {

	public enum EnemyType {
		GREEN1,
		GREEN2,
		GREEN3,
		GREEN4,
		GREEN5,
		BLUE1,
		BLUE2,
		BLUE3,
		BLUE4,
		BLUE5,
		RED1,
		RED2,
		RED3,
		RED4,
		RED5,
		BLACK1,
		BLACK2,
		BLACK3,
		BLACK4,
		BLACK5
	}
	
	private EnemyType type;
	
	public Enemy(Vector2 position, float width, float height, float speed,
			Vector2 velocity, EnemyType type) {
		super(position, width, height, speed, velocity);
		this.type = type;
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta * speed));
		bounds.x = position.x;
		bounds.y = position.y;
	}

	public EnemyType getType() {
		return type;
	}
}
