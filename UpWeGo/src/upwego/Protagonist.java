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
		setAnchorPosition(1,116);
		this.setSize(1,116);
		
		HitTestListener OnTop = new HitTestListener(Platform.class) {

			@Override
			public void invoke(GObject target, Context context) {
				// TODO Auto-generated method stub
				target.setLocation(target.getX(),424);
			}
			
		};
		//addListener(OnTop);
		
	}
	
}
