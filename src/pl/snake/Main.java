package pl.snake;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        Gameplay gameplay = new Gameplay();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeWidth = 905;
        int sizeHeight = 700;
        int width = (dimension.width- sizeWidth) /2;
        int height = (dimension.height- sizeHeight) /2;
        frame.setBounds(width,height,sizeWidth,sizeHeight);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gameplay);
    }
}
