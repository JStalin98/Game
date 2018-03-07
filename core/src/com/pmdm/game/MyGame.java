package com.pmdm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.pmdm.game.screens.BaseScreen;
import com.pmdm.game.screens.GameOverScreen;
import com.pmdm.game.screens.GameScreen;
import com.pmdm.game.screens.LoadingScreen;
import com.pmdm.game.screens.MenuScreen;

/**
 * CLase que actua como principal la cual carga las diferentes escenas y las administra
 */
public class MyGame extends Game {


	// Objeto para administrar las escenas
	private AssetManager manager;


	// Escenas del juego
	public BaseScreen loadingScreen, menuScreen, gameScreen, gameOverScreen;

	@Override
	public void create() {

		manager = new AssetManager();


		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}


	/**
	 * Metodo que sirve para inicilizar las demas escenas
	 */
	public void finishLoading() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);

		setScreen(menuScreen);
	}

	/**
	 * Devuelve el administrador
	 * @return
	 */
	public AssetManager getManager() {
		return manager;
	}

}
