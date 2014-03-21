package upwego;
import upwego.UpWeGo;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;


public class GameView extends GContainer {
	public GameView() {

		super(new GSprite(ImageCache.forClass(UpWeGo.class).get(
				"background.png")));
		
		for(int i=0; i<5; i++) {
			Platform starting = new Platform();
			addAt(starting,i*25+200, 480);
			
		}
		
		Protagonist THEMAN = new Protagonist();
		addAtCenter(THEMAN);
		
		
		

	}

}
