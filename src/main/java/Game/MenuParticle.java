package Game;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObj{
    private Handler handler;
    Random r = new Random();

    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color color;
    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX=5;
        velY=0;

        color = new Color(red,green,blue);

    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if (y<=0||y>=Game.HEIGHT -60) velY *=-1;
        if (x<=0||x>=Game.WIDTH -30) velX *=-1;

        handler.addObject(new Trail((int)x,(int)y, color,15,15,0.05f,ID.Trail,handler));
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color );
        graphics.fillRect((int)x,(int)y,15,15);
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,15,15);
    }

}
