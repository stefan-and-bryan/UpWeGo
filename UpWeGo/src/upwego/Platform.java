package upwego;

import upwego.UpWeGo;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;

public class Platform extends GSprite implements Floor {
	public Platform() {
		
	super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
			"wholeplatform.png")));
	this.setSize(285, 57);
	setAnchorCenter();
	
	FrameListener platformmovement = new FrameListener() {

		@Override
		public void invoke(GObject target, Context context) {
			// TODO Auto-generated method stub
			target.setLocation(target.getX(), target.getY() - getFirstAncestorOf(GameView.class).protmove.getvy());
		}
		
	};
	addListener(platformmovement);

	
	}
	
}
