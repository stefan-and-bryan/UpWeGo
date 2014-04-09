package upwego;
import upwego.UpWeGo;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;


public class GameView extends GContainer {
	
	PlatformController protmove= new PlatformController(
			PlatformControlScheme.ARROWS_SPACE, 1, -20, 3);
	
	public GameView() {

		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"blank.png")));
		setSize(640,640);
			

		
		final MovingBackground background = new MovingBackground();
		addAt(background, 0,-640);
		FrameListener backgroundmovement = new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				// TODO Auto-generated method stub
				target.setLocation(0, target.getY() - protmove.getvy());
			}
			
		};
		background.addListener(backgroundmovement);
		
		for(int i=0; i<5; i++) {
			Platform starting = new Platform();
			addAt(starting,i*25+300, 425);
			
		}
		
		Protagonist THEMAN = new Protagonist();
		addAtCenter(THEMAN);
		THEMAN.addController(protmove);
		
	
		
		
		

	}

}
