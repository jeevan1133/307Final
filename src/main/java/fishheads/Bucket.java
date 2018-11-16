package fishheads;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Bucket {
    public ImageView bucketView;
    private double move_distance; //possible later proc to double
    private double pos_x; //private, dealt with by left() and right()
    private double pos_y;
    
    private Rectangle hitbox; //don't mess with it from outside classes
    private double hitboxModifier;
    private double hitboxXpos;
    private double hitboxYpos;    
    
    public Bucket(double sceneWidth, double sceneHeight){
        Image im = new Image("https://raw.githubusercontent.com/"
                + "nybanez/FishHeads/master/resources/img/"
                + "bucket.png");
        bucketView = new ImageView(im);
        bucketView.setPreserveRatio(true);
        bucketView.setFitWidth(sceneWidth / 10);
        
        move_distance = bucketView.getFitWidth() / 4;
        
        pos_x = (sceneWidth / 2) - (bucketView.getFitWidth() / 2);
        pos_y = sceneHeight -
                (im.getHeight() /(im.getWidth() /
                                  bucketView.getFitWidth()));
        
        hitboxModifier = 0.8;
        hitboxXpos = (sceneWidth / 2) - (bucketView.getFitWidth() * hitboxModifier / 2);
        hitboxYpos = pos_y + (im.getHeight() /(im.getWidth() / bucketView.getFitWidth())) *
                            (hitboxModifier / 16);
        hitbox = new Rectangle(hitboxXpos, hitboxYpos, bucketView.getFitWidth() * hitboxModifier, 10);
        hitbox.setFill(Color.LIGHTGREY);
        
        //starting pos
        bucketView.relocate(pos_x, pos_y);
    }
    
    public void left(){
        if(bucketView.getParent() != null){
            if(bucketView.getParent().contains(pos_x - move_distance, pos_y)){
                bucketView.relocate(pos_x -= move_distance,  pos_y);
                hitbox.relocate(hitboxXpos -= move_distance, hitboxYpos);
            }
        }
    }
    
    public void right(){ //minus one due to possible issues with double
        if(bucketView.getParent() != null){
            if(bucketView.getParent().contains(pos_x + bucketView.getFitWidth() - 1 + move_distance, pos_y)){
                bucketView.relocate(pos_x += move_distance, pos_y);
                hitbox.relocate(hitboxXpos += move_distance, hitboxYpos);
            }
        }
    }
    
    public Rectangle getHitbox(){
        return hitbox;
    }
}