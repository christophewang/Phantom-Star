package eu.phantomstar.model;

import com.badlogic.gdx.math.Vector2;

public class Meteor extends MoveableEntity {
	
	public enum MeteorType {
		BROWNBIG1,
		BROWNBIG2,
		BROWNBIG3,
		BROWNBIG4,
		BROWNMED1,
		BROWNMED2,
		BROWNSMALL1,
		BROWNSMALL2,
		BROWNTINY1,
		BROWNTINY2,
		GREYBIG1,
		GREYBIG2,
		GREYBIG3,
		GREYBIG4,
		GREYMED1,
		GREYMED2,
		GREYSMALL1,
		GREYSMALL2,
		GREYTINY1,
		GREYTINY2
	}
	
	private float rotation;
	private MeteorType type;
	
	public Meteor(Vector2 position, float width, float height, float speed,
			float rotation, Vector2 velocity, MeteorType type) {
		super(position, width, height, speed, velocity);
		this.rotation = rotation;
		this.type = type;
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta * speed));
		rotation += delta * 300;
		bounds.x = position.x;
		bounds.y = position.y;
	}

	public float getRotation() {
		return rotation;
	}

	public MeteorType getType() {
		return type;
	}
}
