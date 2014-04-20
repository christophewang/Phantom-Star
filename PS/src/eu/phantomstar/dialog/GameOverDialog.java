package eu.phantomstar.dialog;

import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

import eu.phantomstar.PhantomStar;
import eu.phantomstar.model.Asset;
import eu.phantomstar.view.GameScreen;
import eu.phantomstar.view.MenuScreen;

public class GameOverDialog extends Dialog {

	private PhantomStar game;
	
	public GameOverDialog(PhantomStar game, String title) {
		super(title, Asset.skin);
		this.game = game;
		padTop(60);
		padLeft(60);
		padRight(60);
		padBottom(60);
		setModal(true);
		setMovable(false);
	}

	@Override
	protected void result(Object object) {
		super.result(object);
		if (object.toString().matches("retry")) {
			game.setScreen(new GameScreen(game));
		} else if (object.toString().matches("exit")) {
			game.setScreen(new MenuScreen(game));
		}
	}
}
