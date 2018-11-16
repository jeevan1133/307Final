package fishheads;

//not allowing "resizing" since I'm not sure how it would
//affect the position of the objects -- might change later
//by utilizing some way of determining the stage width and
//height, then relocating objects, or maybe setting the
//ALIGNMENT PROPERTY of the layout (in caps because this is
//probably the solution); use javafx.scene.layout.[something]
//in place of javafx.scene.Group, which doesn't allow for rszing
import javafx.scene.Group;

import java.util.ArrayList;

public class Container extends Group{
    public Bucket mainCan;
    public ArrayList<Fish> activeFish = new ArrayList<Fish>();

    // method for checking collisions
    public void update(){
    }

    // method for moving fish
    public void drop(){
        if(activeFish.isEmpty()) return;
        
        ArrayList<Fish> toremove = new ArrayList<Fish>();
        for(Fish bone : activeFish){
            bone.drop();

            if(!(bone.inBounds())){ // branch for out of bound fh
                toremove.add(bone);
            }
        }
        missedFish(toremove);

        update();
    }

    //METHOD FOR DEALING WITH MISSED FISH
    public void missedFish(ArrayList<Fish> hitList){
        for(Fish missing: hitList){
            getChildren().remove(missing.fishView);
            activeFish.remove(missing);
        }
    }
}