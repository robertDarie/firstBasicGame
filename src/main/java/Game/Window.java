package Game;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Window extends Canvas {


    private static final long serialVersionUID = 4844489219844765448L;

    public Window(int width, int height, String title, Game game) {
        JFrame f = new JFrame(title);
        f.setPreferredSize(new Dimension(width, height));
        f.setMaximumSize(new Dimension(width, height));
        f.setMinimumSize(new Dimension(width, height));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.add(game);
        f.setVisible(true);
        game.start();
    }
}
