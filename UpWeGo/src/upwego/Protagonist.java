package upwego;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.HitTestListener;

public class Protagonist extends GSprite {
	public Protagonist() {
		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"MAINCHARACTER.png")));
		this.setSize(70,116);
//		setAnchorPosition(1,116);
		setAnchorCenter();
		
		
		HitTestListener OnTop = new HitTestListener(Platform.class) {

			@Override
			public void invoke(GObject target, Context context) {
			
				target.setLocation(target.getX(),target.getY()+1);
			}
			
		};
//		addListener(OnTop);
		
	}
	
}
