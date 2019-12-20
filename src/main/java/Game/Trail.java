package Game;

import java.awt.*;

public class Trail extends  GameObj{

    private float alpha=1;
    private  Handler handler;
    private  Color color;
    private int width;
    private int height;
    private float life;

    public Trail(float x, float y, Color color,int width,int height,float life,ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;
        this.color=color;
        this.width=width;
        this.height=height;
        this.life=life;
    }

    @Override
    public void tick() {
        if (alpha>life){
            alpha -= (life-0.001f);
        }else {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D g2d =(Graphics2D) graphics;
        g2d.setComposite(makeTransparent(alpha));
        graphics.setColor(color);
        graphics.fillRect((int)x,(int)y,width,height);
    }

    private AlphaComposite makeTransparent(float alpha){
        int type=AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
