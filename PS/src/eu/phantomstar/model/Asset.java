package eu.phantomstar.model;

import java.util.EnumMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import eu.phantomstar.model.Enemy.EnemyType;
import eu.phantomstar.model.Meteor.MeteorType;

public class Asset {
	public static Texture splashTexture;
	public static Texture menuTexture;
	public static Texture backgroundTexture;
	public static Texture bulletTexture;
	public static Texture shipTexture;
	public static Texture meteorTexture;
	public static Texture enemyTexture;
	
	public static TextureAtlas atlas;
	
	public static TextureAtlas enemiesAtlas;
	public static EnumMap<Enemy.EnemyType, AtlasRegion> enemyMap;
	
	public static TextureAtlas meteorsAtlas;
	public static EnumMap<Meteor.MeteorType, AtlasRegion> meteorMap;
	
	public static Skin skin;
	
	public static ParticleEffect shipExhaust;
	public static ParticleEffect meteorExhaust;
	
	public static void load() {
		splashTexture = new Texture(Gdx.files.internal("data/splashscreen.png"));
		menuTexture = new Texture(Gdx.files.internal("data/menuBackground.png"));
		shipTexture = new Texture(Gdx.files.internal("data/playerShip1_blue.png"));
		shipTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bulletTexture = new Texture(Gdx.files.internal("data/laserBlue01.png"));
		bulletTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundTexture = new Texture(Gdx.files.internal("data/blackBackground.png"));
		backgroundTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		backgroundTexture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		meteorTexture = new Texture(Gdx.files.internal("data/meteorBrown_big1.png"));
		meteorTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		atlas = new TextureAtlas(Gdx.files.internal("data/button.pack"));
		
		enemiesAtlas = new TextureAtlas(Gdx.files.internal("enemy/enemies.pack"));
		enemyMap = new EnumMap<EnemyType, TextureAtlas.AtlasRegion>(EnemyType.class);
		enemyMap.put(EnemyType.GREEN1, enemiesAtlas.findRegion("enemyGreen1"));
		enemyMap.put(EnemyType.GREEN2, enemiesAtlas.findRegion("enemyGreen2"));
		enemyMap.put(EnemyType.GREEN3, enemiesAtlas.findRegion("enemyGreen3"));
		enemyMap.put(EnemyType.GREEN4, enemiesAtlas.findRegion("enemyGreen4"));
		enemyMap.put(EnemyType.GREEN5, enemiesAtlas.findRegion("enemyGreen5"));
		enemyMap.put(EnemyType.BLUE1, enemiesAtlas.findRegion("enemyBlue1"));
		enemyMap.put(EnemyType.BLUE2, enemiesAtlas.findRegion("enemyBlue2"));
		enemyMap.put(EnemyType.BLUE3, enemiesAtlas.findRegion("enemyBlue3"));
		enemyMap.put(EnemyType.BLUE4, enemiesAtlas.findRegion("enemyBlue4"));
		enemyMap.put(EnemyType.BLUE5, enemiesAtlas.findRegion("enemyBlue5"));
		enemyMap.put(EnemyType.RED1, enemiesAtlas.findRegion("enemyRed1"));
		enemyMap.put(EnemyType.RED2, enemiesAtlas.findRegion("enemyRed2"));
		enemyMap.put(EnemyType.RED3, enemiesAtlas.findRegion("enemyRed3"));
		enemyMap.put(EnemyType.RED4, enemiesAtlas.findRegion("enemyRed4"));
		enemyMap.put(EnemyType.RED5, enemiesAtlas.findRegion("enemyRed5"));
		enemyMap.put(EnemyType.BLACK1, enemiesAtlas.findRegion("enemyBlack1"));
		enemyMap.put(EnemyType.BLACK2, enemiesAtlas.findRegion("enemyBlack2"));
		enemyMap.put(EnemyType.BLACK3, enemiesAtlas.findRegion("enemyBlack3"));
		enemyMap.put(EnemyType.BLACK4, enemiesAtlas.findRegion("enemyBlack4"));
		enemyMap.put(EnemyType.BLACK5, enemiesAtlas.findRegion("enemyBlack5"));
		
		meteorsAtlas = new TextureAtlas(Gdx.files.internal("meteor/meteors.pack"));
		meteorMap = new EnumMap<MeteorType, TextureAtlas.AtlasRegion>(MeteorType.class);
		meteorMap.put(MeteorType.BROWNBIG1, meteorsAtlas.findRegion("meteorBrown_big1"));
		meteorMap.put(MeteorType.BROWNBIG2, meteorsAtlas.findRegion("meteorBrown_big2"));
		meteorMap.put(MeteorType.BROWNBIG3, meteorsAtlas.findRegion("meteorBrown_big3"));
		meteorMap.put(MeteorType.BROWNBIG4, meteorsAtlas.findRegion("meteorBrown_big4"));
		meteorMap.put(MeteorType.BROWNMED1, meteorsAtlas.findRegion("meteorBrown_med1"));
		meteorMap.put(MeteorType.BROWNMED2, meteorsAtlas.findRegion("meteorBrown_med2"));
		meteorMap.put(MeteorType.BROWNSMALL1, meteorsAtlas.findRegion("meteorBrown_small1"));
		meteorMap.put(MeteorType.BROWNSMALL2, meteorsAtlas.findRegion("meteorBrown_small2"));
		meteorMap.put(MeteorType.BROWNTINY1, meteorsAtlas.findRegion("meteorBrown_tiny1"));
		meteorMap.put(MeteorType.BROWNTINY2, meteorsAtlas.findRegion("meteorBrown_tiny2"));
		meteorMap.put(MeteorType.GREYBIG1, meteorsAtlas.findRegion("meteorGrey_big1"));
		meteorMap.put(MeteorType.GREYBIG2, meteorsAtlas.findRegion("meteorGrey_big2"));
		meteorMap.put(MeteorType.GREYBIG3, meteorsAtlas.findRegion("meteorGrey_big3"));
		meteorMap.put(MeteorType.GREYBIG4, meteorsAtlas.findRegion("meteorGrey_big4"));
		meteorMap.put(MeteorType.GREYMED1, meteorsAtlas.findRegion("meteorGrey_med1"));
		meteorMap.put(MeteorType.GREYMED2, meteorsAtlas.findRegion("meteorGrey_med2"));
		meteorMap.put(MeteorType.GREYSMALL1, meteorsAtlas.findRegion("meteorGrey_small1"));
		meteorMap.put(MeteorType.GREYSMALL2, meteorsAtlas.findRegion("meteorGrey_small2"));
		meteorMap.put(MeteorType.GREYTINY1, meteorsAtlas.findRegion("meteorGrey_tiny1"));
		meteorMap.put(MeteorType.GREYTINY2, meteorsAtlas.findRegion("meteorGrey_tiny2"));
		
		skin = new Skin(Gdx.files.internal("data/skin.json"), atlas);
		
		shipExhaust = new ParticleEffect();
		shipExhaust.load(Gdx.files.internal("effect/shipExhaust.p"), Gdx.files.internal("data"));
		shipExhaust.flipY();
		meteorExhaust = new ParticleEffect();
		meteorExhaust.load(Gdx.files.internal("effect/meteorExhaust.p"), Gdx.files.internal("data"));
	}
	
	public static void dispose() {
		splashTexture.dispose();
		menuTexture.dispose();
		backgroundTexture.dispose();
		bulletTexture.dispose();
		shipTexture.dispose();
		meteorTexture.dispose();
		
		atlas.dispose();
		enemiesAtlas.dispose();
		meteorsAtlas.dispose();
		shipExhaust.dispose();
		meteorExhaust.dispose();
	}
}
