package Game;

import java.awt.*;

public class BasicEnemy extends GameObj {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=3;
        velY=3;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=0||y>=Game.HEIGHT -60) velY *=-1;
        if (x<=0||x>=Game.WIDTH -30) velX *=-1;

//        handler.addObject(new Trail((int)x,(int)y,Color.red,15,15,0.1f,ID.Trail,handler));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x,(int)y,30,30);
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,30,30);
    }

}
