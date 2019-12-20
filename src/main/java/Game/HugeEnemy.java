package Game;

import java.awt.*;

public class HugeEnemy extends GameObj{

    private Handler handler;

    public HugeEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=2;
        velY=2;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=0||y>=Game.HEIGHT -60) velY *=-1;
        if (x<=0||x>=Game.WIDTH -30) velX *=-1;

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect((int)x,(int)y,50,50);
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,50,50);
    }
}
