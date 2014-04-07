package upwego;

import jgame.GSprite;
import jgame.ImageCache;

public class Protagonist extends GSprite {
	public Protagonist() {
		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"MAINCHARACTER.png")));
		this.setSize(70,116);
		setAnchorCenter();
		PlatformController klc = new PlatformController(
				PlatformControlScheme.WASD, -10, -20, 3);
	//	addController(klc);
		PlatformController klc2 = new PlatformController(
				PlatformControlScheme.ARROWS_SPACE, 1, -20, 3);
		addController(klc2);
	}

}
