package upwego;

import jgame.GSprite;
import jgame.ImageCache;

public class MovingBackground extends GSprite {
	
	public MovingBackground() {

	super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
			"backgroundmove.png")));
	setSize(0,1920);
	setAnchorCenter();



	}

}
