package pl.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private int lengthOfSnake = 3;
    private int moves =0;

    private Timer timer;
    private int delay = 100;

    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;

    private ImageIcon titleImage= new ImageIcon("title.png");
    private ImageIcon downHeadImage = new ImageIcon("downhead.png");
    private ImageIcon upHeadImage = new ImageIcon("uphead.png");
    private ImageIcon leftHeadImage = new ImageIcon("lefthead.png");
    private ImageIcon rightHeadImage = new ImageIcon("righthead.png");
    private ImageIcon snakeImage = new ImageIcon("snake.png");
    private ImageIcon appleImage = new ImageIcon("apple.png");


    public Gameplay(){

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){

        if(moves == 0){
            snakeXlength[2]=50;
            snakeXlength[1]=75;
            snakeXlength[0]=100;

            snakeYlength[2]=100;
            snakeYlength[1]=100;
            snakeYlength[0]=100;
        }

        //draw title
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);
        titleImage.paintIcon(this,g,25,11);

        //draw gameplay
        g.setColor(Color.WHITE);
        g.fillRect(25,75,850, 576);

        rightHeadImage.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);

        for(int a=0; a<lengthOfSnake; a++){
            if(a==0 && right){
                rightHeadImage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }else if(a==0 && left){
                leftHeadImage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }else if(a==0 && up){
                upHeadImage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }else if(a==0 && down){
                downHeadImage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
            if (a!=0){
                snakeImage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
