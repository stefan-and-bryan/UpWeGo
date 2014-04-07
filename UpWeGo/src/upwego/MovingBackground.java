package upwego;

import jgame.GSprite;
import jgame.ImageCache;

public class MovingBackground extends GSprite {
	
	public MovingBackground() {

	super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
			"backgroundmove.png")));
	PlatformController klc2 = new PlatformController(
			PlatformControlScheme.ARROWS_SPACE, 0, -20, 0);
	addController(klc2);
	}

}
