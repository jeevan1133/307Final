package fishheads;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;

public class Fish{
    static ImageView fishView = new ImageView();
    private double move_distance; //possible later proc to double
    private double pos_x;
    private double pos_y;
    
    private Rectangle  hitbox;
    private double hitboxModifier;
    private double hitboxXpos;
    private double hitboxYpos;
    
    private Random rng = new Random();
    
    //note on FPM (Fish Per Minute): frames will ideally update
    //each 1/4 of a second or a duration of 250 milliseconds,
    //the move_distance will reflect this - showing the amount
    //of distance to keep the ideal number of fish on the screen
    
    public Fish(double sceneWidth, double sceneHeight, double fpm){
        Image im = new Image("https://raw.githubusercontent.com/"
                + "nybanez/FishHeads/master/resources/img/"
                + "fish_head.png");
        fishView = new ImageView(im);
        fishView.setPreserveRatio(true);
        fishView.setFitWidth(sceneWidth * 8 / 100); // 8/10 width of bucket
        fishView.setEffect(new DropShadow(10, Color.SNOW));
        
        move_distance = (sceneHeight / (60 / fpm) * 0.250);
        
        pos_x = rng.nextInt((int) (sceneWidth - fishView.getFitWidth()));
        pos_y = 200;
        
//        hitboxModifier = 0.8; //probably used to alter the height of the hitbox (jaw to top of head)
//        hitboxXpos = pos_x; //might be modified if widths are different
//        hitboxYpos = [insert hitbox topleft corner y-position];
//        hitbox = new Rectangle(hitboxXpos, hitboxYpos, [insert hitbox width], [insert hitbox height]);
//        hitbox.setFill(Color.LIGHTGREY);
        
        //starting pos
        fishView.relocate(pos_x, pos_y);
    }
    
    public boolean inBounds(){
        if(fishView.getParent() == null){
            return false;
        }
        
        //use (pos_x + fishView.getFitWidth() - 1, pos_y) if checking x position too
        return fishView.getParent().contains(0, pos_y);
    }
    
    public void drop(){
        fishView.relocate(pos_x, pos_y += move_distance);
//        hitbox.relocate(hitboxXpos, hitboxYpos += move_distance);
    }
    
    public Rectangle getHitbox(){
        return hitbox;
    }

	public double getHitboxXpos() {
		return hitboxXpos;
	}

	public void setHitboxXpos(double hitboxXpos) {
		this.hitboxXpos = hitboxXpos;
	}

	public double getHitboxModifier() {
		return hitboxModifier;
	}

	public void setHitboxModifier(double hitboxModifier) {
		this.hitboxModifier = hitboxModifier;
	}

	public double getHitboxYpos() {
		return hitboxYpos;
	}

	public void setHitboxYpos(double hitboxYpos) {
		this.hitboxYpos = hitboxYpos;
	}
}