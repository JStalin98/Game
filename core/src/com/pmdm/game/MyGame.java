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

public class MyGame extends Game {

	 /** This is the asset manager we use to centralize the assets. */
	private AssetManager manager;

	/**
	 * These are the screens that we use in this game. I invite you to use a better system than
	 * just public variables. For instance, you could create an ArrayList or maybe use some
	 * structure such as a map where you can associate a number or a string to a screen.
	 */
	public BaseScreen loadingScreen, menuScreen, gameScreen, gameOverScreen;

	@Override
	public void create() {
		// Initialize the asset manager. We add every aset to the manager so that it can be loaded
		// inside the LoadingScreen screen. Remember to put the name of the asset in the first
		// argument, then the type of the asset in the second argument.
		manager = new AssetManager();

		// Enter the loading screen to load the assets.
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}

	/**
	 * This method is invoked by LoadingScreen when all the assets are loaded. Use this method
	 * as a second-step loader. You can load the rest of the screens here and jump to the main
	 * screen now that everything is loaded.
	 */
	public void finishLoading() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);

		setScreen(menuScreen);
	}

	public AssetManager getManager() {
		return manager;
	}

}
