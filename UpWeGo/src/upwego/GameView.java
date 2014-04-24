package upwego;
import upwego.UpWeGo;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;


public class GameView extends GContainer {
	
	public PlatformController protmove= new PlatformController(
			PlatformControlScheme.ARROWS_SPACE, 1, -20, 3);
	
	public GameView() {

		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"blank.png")));
		setSize(640,640);
			

		
		final MovingBackground background = new MovingBackground();
		addAtCenter(background);
		FrameListener backgroundmovement = new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				// TODO Auto-generated method stub
				target.setLocation(0, target.getY() - protmove.getvy());
			}
			
		};
		
		FrameListener Respawn = new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				// TODO Auto-generated method stub
				if (target.getY()+(.5*target.getHeight())>640)
					context.setCurrentGameView(UpWeGo.View.GAME_OVER);
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
		THEMAN.addListener(Respawn);
		
		
	
		
		
		

	}

}
