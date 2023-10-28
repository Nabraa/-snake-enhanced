import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(String title, int WIDTH, int HEIGHT, MainGame game){

        Dimension d = new Dimension(WIDTH,HEIGHT);
        JFrame jFrame = new JFrame();
        jFrame.add(game);
        jFrame.setMinimumSize(d);
        jFrame.setVisible(true);
        jFrame.setMaximumSize(d);
        jFrame.setPreferredSize(d);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        game.start(); // initilaise thread, and start a thread. sets value "running" to true


    }

}
