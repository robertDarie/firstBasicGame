package Game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = 555184803424892501L;

    public static final int WIDTH = 1080 ;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private HUD hud;
    private Menu menu;

    public enum STATE {
        Menu,
        Help,
        Game,
        End
    }

    public STATE gameState = STATE.Menu;


    private Random r;
    private Thread thread;
    public boolean running = false;
    public Handler handler;
    private Spawn spawn;


    public Game() {
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this,handler,hud);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        new Window(WIDTH, HEIGHT, "My First Game ^.^", this);

        r = new Random();
        spawn = new Spawn(handler, hud);


        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH / 2 - 16, HEIGHT / 2 - 16, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
        }
        else if(gameState==STATE.Menu){
            for(int i = 0; i<20; i++){
                handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
            }for(int i = 0; i<20; i++){
                handler.addObject(new MenuParticle2(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle2, handler));
            }
        }


    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
            spawn.tick();

            if(HUD.HEALTH <=0){
                HUD.HEALTH =100;
                gameState = STATE.End;
                handler.object.clear();
            }
        }else if (gameState==STATE.Menu||gameState==STATE.End){
            menu.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        if (gameState == STATE.Game) {
            hud.render(g);
        }else if (gameState==STATE.Menu||gameState==STATE.Help||gameState==STATE.End){
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }


    public static void main(String[] args) {

        new Game();
    }


}
