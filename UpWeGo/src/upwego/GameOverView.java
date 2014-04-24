package upwego;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class GameOverView extends GContainer {
	public GameOverView() {
		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"BestGameoverScreenEver.png")));
		setSize(640, 640);

	}

}
