package upwego;
import upwego.UpWeGo;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;


public class GameView extends GContainer {
	public GameView() {

		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"blank.png")));
		MovingBackground background = new MovingBackground();
		addAt(background, 0,-640);		
		for(int i=0; i<5; i++) {
			Platform starting = new Platform();
			addAt(starting,i*25+300, 425);
			
		}
		
		Protagonist THEMAN = new Protagonist();
		addAtCenter(THEMAN);

		
	
		
		
		

	}

}
