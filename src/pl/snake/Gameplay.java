package pl.snake;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    private ImageIcon titleImage= new ImageIcon("title.png");



    public Gameplay(){

    }

    public void paint(Graphics g){

        //border title
        g.setColor(Color.GRAY);
        g.drawRect(24,10,851,55);
        titleImage.paintIcon(this,g,25,11);

        //border gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);

        //bacground gameplay
        g.setColor(Color.WHITE);
        g.fillRect(25,75,850, 576);


    }

}
