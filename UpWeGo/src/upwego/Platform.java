package upwego;

import upwego.UpWeGo;
import jgame.GSprite;
import jgame.ImageCache;

public class Platform extends GSprite implements Floor {
	public Platform() {
	super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
			"greensquare.jpg")));
	}

}
