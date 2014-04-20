package eu.phantomstar.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Audio {

	public static Music song = Gdx.audio.newMusic(Gdx.files.internal("audio/determination.mp3"));
	public static Sound shoot = Gdx.audio.newSound(Gdx.files.internal("audio/shoot.wav"));
	public static Sound explosion = Gdx.audio.newSound(Gdx.files.internal("audio/boom.wav"));
	
	public static void playMusic(boolean looping) {
		song.setLooping(looping);
		song.play();
	}
	
	public static void stopMusic() {
		song.stop();
	}
	
	public static void shoot() {
		shoot.play();
	}
	
	public static void explosion() {
		explosion.play();
	}
	
	public static void dispose() {
		song.dispose();
		shoot.dispose();
		explosion.dispose();
	}
}
