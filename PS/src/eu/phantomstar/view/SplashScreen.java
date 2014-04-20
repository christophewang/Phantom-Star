package eu.phantomstar.view;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import eu.phantomstar.PhantomStar;
import eu.phantomstar.model.Asset;
import eu.phantomstar.tween.SpriteTween;

public class SplashScreen implements Screen {

	private PhantomStar game;
	private Sprite sprite;
	private SpriteBatch spriteBatch;
	private TweenManager tweenManager;
	
	public SplashScreen(PhantomStar game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tweenManager.update(delta);
		spriteBatch.begin();
		sprite.draw(spriteBatch);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		sprite = new Sprite(Asset.splashTexture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch = new SpriteBatch();
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		Tween.set(sprite, SpriteTween.ALPHA).target(0).start(tweenManager);
		Tween.to(sprite, SpriteTween.ALPHA, 0.5f).target(1).repeatYoyo(1, 0.5f).setCallback(new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				game.setScreen(new MenuScreen(game));
			}
		}).start(tweenManager);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
	}
}
