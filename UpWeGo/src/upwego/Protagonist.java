package upwego;

import jgame.GSprite;
import jgame.ImageCache;

public class Protagonist extends GSprite {
	public Protagonist() {
		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"MAINCHARACTER.jpg")));
	}

}
