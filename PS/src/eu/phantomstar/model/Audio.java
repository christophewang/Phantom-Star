package eu.phantomstar.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Audio {

	public static Music song = Gdx.audio.newMusic(Gdx.files.internal("audio/xeon6.ogg"));
	public static Music gameover = Gdx.audio.newMusic(Gdx.files.internal("audio/gameover.wav"));
	public static Sound shoot = Gdx.audio.newSound(Gdx.files.internal("audio/shoot.ogg"));
	public static Sound explosion = Gdx.audio.newSound(Gdx.files.internal("audio/explosion.ogg"));
	public static Sound shipExplosion = Gdx.audio.newSound(Gdx.files.internal("audio/explosion1.wav"));
	public static Sound click = Gdx.audio.newSound(Gdx.files.internal("audio/click.ogg"));
	
	public static void playMusic(boolean looping) {
		song.setLooping(looping);
		Timer.schedule(new Task(){
		    @Override
		    public void run() {
				song.play();
		    }
		}, 1);
	}
	
	public static void playGameOverSong(boolean looping) {
		gameover.setLooping(looping);
		gameover.play();
	}
	
	public static void dispose() {
		song.dispose();
		gameover.dispose();
		shoot.dispose();
		explosion.dispose();
	}
}
