package fishheads;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyPressHandler implements EventHandler<KeyEvent>{
    public Bucket tin;
    
    public KeyPressHandler(Bucket catcher){
        tin = catcher;
    }
    
    public void handle(KeyEvent keyEnter){
        KeyCode enteredKey = keyEnter.getCode();
        if(enteredKey == KeyCode.LEFT){
            tin.left();
        }else if(enteredKey == KeyCode.RIGHT){
            tin.right();
        }
    }
}