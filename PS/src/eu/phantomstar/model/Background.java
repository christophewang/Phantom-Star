package eu.phantomstar.model;

import com.badlogic.gdx.Gdx;

public class Background {
	
	private float scrollTimer;

	public Background() {
		scrollTimer = 0f;
	}
	
	public void update() {
		scrollTimer += Gdx.graphics.getDeltaTime();
		if (scrollTimer > 1f) {
			scrollTimer = 0f;
		}
	}

	public float getScrollTimer() {
		return scrollTimer;
	}
}
