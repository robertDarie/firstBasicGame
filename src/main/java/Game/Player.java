package Game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObj {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 35);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObj temp = handler.object.get(i);
            if (temp.getId() == ID.BasicEnemy
                    || temp.getId() == ID.FastEnemy
                    || temp.getId() == ID.HugeEnemy
                    ||temp.getId()==ID.WidthEnemy
                    ||temp.getId()==ID.SmartEnemy) {
                if (getBounds().intersects(temp.getBounds())) {
                    //coliziunea
                    HUD.HEALTH -= 1;
                }
                if (temp.getId() == ID.HugeEnemy) {
                    if (getBounds().intersects(temp.getBounds())) {
                        //coliziunea
                        HUD.HEALTH -= 2;
                    }
                }
            }
        }
    }

    @Override
    public void render(Graphics graphics) {

        graphics.setColor(Color.CYAN);
        graphics.fillRect((int)x,(int) y, 40, 40);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int) y, 40, 40);
    }
}
