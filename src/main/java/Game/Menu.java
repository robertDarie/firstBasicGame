package Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLOutput;
import java.util.Random;


public class Menu extends MouseAdapter {

    Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //menu
        if (game.gameState == Game.STATE.Menu) {
            //play button
            if (mouseOver(mx, my, 350, 300, 350, 100)) {
                game.gameState = Game.STATE.Game;
                handler.object.clear();
                handler.addObject(new Player(Game.WIDTH / 2 - 16, Game.HEIGHT / 2 - 16, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }
            //help button
            if (mouseOver(mx, my, 350, 450, 350, 100)) {
                game.gameState = Game.STATE.Help;
                handler.object.clear();
            }
            //quit button
            if (mouseOver(mx, my, 350, 600, 350, 100)) {
                System.exit(1);
            }
        }
        //back button for help
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 350, 600, 350, 100)) {
                game.gameState = Game.STATE.Menu;
                for (int i = 0; i < 20; i++) {
                    handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
                }
                for (int i = 0; i < 20; i++) {
                    handler.addObject(new MenuParticle2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle2, handler));
                }
                return;
            }
        }

        if (game.gameState == Game.STATE.End) {
            //try again button
            if (mouseOver(mx, my, 350, 600, 350, 100)) {
                game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);
                handler.addObject(new Player(Game.WIDTH / 2 - 16, Game.HEIGHT / 2 - 16, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            //back to menu button
            }if (mouseOver(mx, my, 350, 450, 350, 100)){
                hud.setLevel(1);
                hud.setScore(0);
                game.gameState=Game.STATE.Menu;
                for (int i = 0; i < 20; i++) {
                    handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
                }
                for (int i = 0; i < 20; i++) {
                    handler.addObject(new MenuParticle2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle2, handler));
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

    public void tick() {

    }

    public void render(Graphics graphics) {
        if (game.gameState == Game.STATE.Menu) {
            Font font = new Font("arial", 1, 70);
            Font font2 = new Font("arial", 1, 50);

            graphics.setFont(font);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Menu", 430, 150);

            graphics.setFont(font2);
            ;
            graphics.drawRect(350, 300, 350, 100);
            graphics.drawString("Play", 470, 365);

            graphics.drawRect(350, 450, 350, 100);
            graphics.drawString("Help", 470, 515);

            graphics.drawRect(350, 600, 350, 100);
            graphics.drawString("Quit", 470, 665);
        } else if (game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 1, 70);
            Font font2 = new Font("arial", 1, 50);

            graphics.setFont(font);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Help", 430, 150);

            graphics.setFont(font2);
            graphics.drawString("Goal:", 30, 200);
            graphics.drawString("Dodge the enemies.", 30, 250);
            graphics.drawString("Player Movement:", 30, 350);
            graphics.drawString("WASD/Arrows.", 30, 400);
            graphics.drawString("Level up:", 550, 200);
            graphics.drawString("500 points needed ", 550, 250);
            graphics.drawString("for level up. ", 550, 300);
            graphics.drawString("Enemy spawn: ", 550, 400);
            graphics.drawString("Each level spawn", 550, 450);
            graphics.drawString("new enemy/enemies.", 550, 500);

            graphics.setFont(font2);
            graphics.drawRect(350, 600, 350, 100);
            graphics.drawString("Back", 470, 665);
        } else if (game.gameState == Game.STATE.End) {
            Font font = new Font("arial", 1, 70);
            Font font2 = new Font("arial", 1, 50);
            Font font3 = new Font("arial", 1, 50);

            graphics.setFont(font);
            graphics.setColor(Color.WHITE);
            graphics.drawString("Game Over", 360, 150);

            graphics.setFont(font2);
            graphics.drawString("Your Score: " + hud.getScore(), 330, 300);

            graphics.setFont(font2);
            graphics.drawRect(350, 600, 350, 100);
            graphics.drawString("Try Again", 410, 665);

            graphics.setFont(font3);
            graphics.drawRect(350, 450, 350, 100);
            graphics.drawString("Back to menu", 360, 515);
        }
    }
}
