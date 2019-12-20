package Game;

import java.awt.*;

public class HUD {

    public  static  int HEALTH = 100;
    public  int greenValue = 255;

    private int score=0;
    private int level=1;
    public void  tick(){

        HEALTH = (int) Game.clamp(HEALTH,0,100);

        greenValue= (int) Game.clamp(greenValue,0,255);

        greenValue = HEALTH*2;

        score++;

    }

    public  void  render(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillRect(400,15,200,15);
        graphics.setColor(new Color(75,greenValue,0));
        graphics.fillRect(400,15,HEALTH*2,15);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(400,15,200,15);

        graphics.drawString(" Score: "+ score,10,40);
        graphics.drawString(" Level: "+ level,10,20);
    }
    public void score(int score){
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score=score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
