package Game;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();


    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (hud.getScore()==1){
            scoreKeep=0;
        }
        if (scoreKeep >= 500) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
            }
            if (hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
            }
            if (hud.getLevel() == 6) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
            }
            if (hud.getLevel() == 8) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
            }
            if (hud.getLevel() == 10) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
            }
            if (hud.getLevel() == 23) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
            }
            if (hud.getLevel() == 26) {
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
            }
            if (hud.getLevel() == 29) {
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new WidthEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.WidthEnemy, handler));
            }
            if (hud.getLevel() == 232) {
                handler.addObject(new HugeEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.HugeEnemy, handler));
            }
        }
    }
}
