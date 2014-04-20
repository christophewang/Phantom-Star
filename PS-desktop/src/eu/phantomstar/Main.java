package eu.phantomstar;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = PhantomStar.TITLE + " " + PhantomStar.VERSION;
		cfg.useGL20 = true;
		cfg.width = 480;
		cfg.height = 800;
		cfg.resizable = false;
		cfg.fullscreen = false;
		cfg.forceExit = true;
		cfg.vSyncEnabled = true;
		
		new LwjglApplication(new PhantomStar(), cfg);
	}
}
