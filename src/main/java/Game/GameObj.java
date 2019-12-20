package Game;

import java.awt.*;

public abstract class GameObj {

    protected float x, y;
    protected  ID id;
    protected  float velX,velY;

    public GameObj(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick();
    public abstract void render(Graphics graphics);
    public abstract  Rectangle getBounds();
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
