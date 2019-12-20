package Game;



import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Handler {

    ArrayList<GameObj>object =new ArrayList<GameObj>();

    public  void  tick(){
        for( int i=0; i<object.size();i++){
            GameObj temo =  object.get(i);

            temo.tick();
        }
    }
    public  void  render(Graphics graphics){
        for( int i=0; i<object.size();i++){
            GameObj temo =  object.get(i);

            temo.render(graphics);
        }
    }
    public void addObject(GameObj object){
        this.object.add(object);
    }
    public void removeObject(GameObj object){
        this.object.remove(object);
    }

}
