package eu.phantomstar.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import eu.phantomstar.PhantomStar;
import eu.phantomstar.model.Asset;
import eu.phantomstar.model.Audio;

public class MenuScreen implements Screen {
	
	private PhantomStar game;
	private Stage stage;
	private TextButton playButton;
	private TextButton scoresButton;
	private TextButton settingsButton;
	
	public MenuScreen(PhantomStar game) {
		this.game = game;
	}

	public class MenuBackground extends Actor {
        @Override
        public void draw(SpriteBatch batch, float alpha) {
        	batch.draw(Asset.menuTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage = new Stage();
		stage.clear();
		stage.addActor(new MenuBackground());
		playButton.setSize(width / 2, height / 20);
		playButton.setPosition(width / 2 - playButton.getWidth() / 2, height / 2 - playButton.getHeight() / 10);
		playButton.addListener(new InputListener() {
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new GameScreen(game));
			}
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
		});
		scoresButton.setSize(width / 2, height / 20);
		scoresButton.setPosition(width / 2 - scoresButton.getWidth() / 2, playButton.getY() - height / 10);
		scoresButton.addListener(new InputListener() {
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new ScoresScreen());
			}
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
		});
		settingsButton.setSize(width / 2, height / 20);
		settingsButton.setPosition(width / 2 - settingsButton.getWidth() / 2, scoresButton.getY() - height / 10);
		settingsButton.addListener(new InputListener() {
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new SettingsScreen());
			}
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
		});
		stage.addActor(playButton);
		stage.addActor(scoresButton);
		stage.addActor(settingsButton);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void show() {
		playButton = new TextButton("Play", Asset.skin);
		scoresButton = new TextButton("HighScores", Asset.skin);
		settingsButton = new TextButton("Settings", Asset.skin);
		Audio.playMusic(true);
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
		stage.dispose();
	}
}
