package eu.phantomstar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

import eu.phantomstar.model.Asset;
import eu.phantomstar.model.Audio;
import eu.phantomstar.view.SplashScreen;

public class PhantomStar extends Game {

	public static final String TITLE = "PhantomStar";
	public static final String VERSION = "0.2";
	public static final boolean DEBUG = true;
	private FPSLogger fpsLogger;

	@Override
	public void create() {
		Asset.load();
		setScreen(new SplashScreen(this));
		fpsLogger = new FPSLogger();
	}

	@Override
	public void dispose() {
		super.dispose();
		Asset.dispose();
		Audio.dispose();
	}

	@Override
	public void render() {
		super.render();
		fpsLogger.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
