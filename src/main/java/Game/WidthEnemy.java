package Game;

import java.awt.*;

public class WidthEnemy extends GameObj {

    private Handler handler;

    public WidthEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=5;
        velY=0;
    }

    @Override
    public void tick() {
        x+=velX;
//        y+=velY;

        if (y<=0||y>=Game.HEIGHT -60) velY *=-1;
        if (x<=0||x>=Game.WIDTH -30) velX *=-1;

//        handler.addObject(new Trail(x,y,Color.red,15,15,0.1f,ID.Trail,handler));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int)x,(int)y,40,40);
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,40,40);
    }
}
