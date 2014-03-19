package upwego;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;
import jgame.SoundManager;

public class UpWeGo extends Game {

	public static void main(String[] args) {

		UpWeGo TDGame = new UpWeGo();
		TDGame.startGame("UpWeGo");
	}

	public UpWeGo() {
		ImageCache.create(UpWeGo.class, "/TDResources/");
		SoundManager.create(UpWeGo.class, "/TDResources/");

		GRootContainer root = new GRootContainer(Color.GREEN);
		setRootContainer(root);

		StartMenu startMenu = new StartMenu();
		root.addView(View.START, startMenu);

	//	StartMenuAnimation startmenuAnimation = new StartMenuAnimation();
	//	root.addView(View.STARTANIM, startmenuAnimation);

		GameView gameView = new GameView();
		root.addView(View.GAME, gameView);

		GameOverView gameOverView = new GameOverView();
		root.addView(View.GAME_OVER, gameOverView);
	}

	public enum View {
		START, STARTANIM, GAME, GAME_OVER;
	}
}
