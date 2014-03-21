package upwego;
import upwego.UpWeGo;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;


public class GameView extends GContainer {
	public GameView() {

		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"/background.png")));
	}

}
