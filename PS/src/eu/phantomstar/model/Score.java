package eu.phantomstar.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;

public class Score {
	
	private int score;
	private BitmapFont font;
	private BitmapFontCache bitmapFontCache;
	
	public Score() {
		score = 0;
		font = new BitmapFont(Gdx.files.internal("data/white.fnt"), false);
		bitmapFontCache = new BitmapFontCache(font);
		bitmapFontCache.setText("000", 0, 0);
	}

	public void update() {
		bitmapFontCache.setText(Integer.toString(score), 0, 0);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public BitmapFontCache getBitmapFontCache() {
		return bitmapFontCache;
	}
}
