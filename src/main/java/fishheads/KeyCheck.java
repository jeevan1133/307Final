package fishheads;

//imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;

import javafx.scene.paint.Color;
//end of imports

public class KeyCheck extends Application{
    double default_scene_width = 800;
    double default_scene_height = 500;
    double fpm = 6; //fish per minute
    
    public void start(Stage stage_One) {
    	
        @SuppressWarnings("unused")
		long start_time = System.currentTimeMillis();
        @SuppressWarnings("unused")
		int fish_added = 0;
        
        stage_One.setTitle("KeyCheck Class");
        stage_One.show();
        
        Container root = new Container();
        Scene scene_One = new Scene(root,
                                    default_scene_width,
                                    default_scene_height,
                                    Color.DARKCYAN);
        
        stage_One.setScene(scene_One);
        //note that the scene can be set retroactively
        //(after "show()"), thus adding and removing objects will
        //also show up -- since the "painting" is probably
        //immediate, will likely use modulus and system clock
        //to determine checks for relocating objects (except for
        //bucket and collision checks)
        
        //background image (image is credited to Rnbc - don't sue me, I'm poor </3)
        //this means either get a replacement image, or credit more overtly
        ImageView backgroundimv = new ImageView("https://upload.wikimedia.org/wikipedia"
                                              + "/commons/7/7b/Seascape_after_sunset.jpg");
        backgroundimv.setFitWidth(default_scene_width);
        backgroundimv.setFitHeight(default_scene_height);
        
        GaussianBlur blurandglow = new GaussianBlur();
        blurandglow.setInput(new Glow(0.8));
        backgroundimv.setEffect(blurandglow);
        
        root.getChildren().add(backgroundimv);
        //end background image
        
        Bucket catcher = new Bucket(default_scene_width,
                                    default_scene_height);
        
        root.getChildren().add(catcher.bucketView);
        root.mainCan = catcher;
        root.setOnKeyPressed(new KeyPressHandler(catcher));
        root.getChildren().add(catcher.getHitbox());
        
        catcher.getHitbox().toBack(); //comment out to see hitbox for bucket
        
        root.activeFish.add(new Fish(default_scene_width, default_scene_height, fpm));
        root.getChildren().add(root.activeFish.get(root.activeFish.size() - 1).fishView);
        
        root.requestFocus();
//        for(int m = 0; m < 60; m++){
//            root.drop();
//        }
    }
    
    public static void startup(String[] args) {
        launch(args);
    }
}