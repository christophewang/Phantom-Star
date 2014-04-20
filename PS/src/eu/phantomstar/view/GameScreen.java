package eu.phantomstar.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import eu.phantomstar.PhantomStar;
import eu.phantomstar.model.World;
import eu.phantomstar.model.WorldRenderer;

public class GameScreen implements Screen {

	private World world;
	private WorldRenderer worldRenderer;
	private OrthographicCamera camera;
	
	public GameScreen(PhantomStar game) {
		world = new World();
		worldRenderer = new WorldRenderer(game, world);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		world.update(delta, camera);
		worldRenderer.render(camera);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		worldRenderer.dispose();
	}
}
