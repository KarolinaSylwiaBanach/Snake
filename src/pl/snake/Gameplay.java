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
        timer.start();
        if(right){
            for(int r=lengthOfSnake-1; r >=0 ;r--){
                snakeYlength[r+1]=snakeYlength[r];
            }
            for(int r=lengthOfSnake;r>=0;r--){
                if(r==0) {
                    snakeXlength[r] = snakeXlength[r] + 25;
                }else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                    if(snakeXlength[r]>850){
                    snakeXlength[r]=25;
                }
            }
            repaint();
        }
        if(left){
            for(int r=lengthOfSnake-1; r >=0 ;r--){
                snakeYlength[r+1]=snakeYlength[r];
            }
            for(int r=lengthOfSnake;r>=0;r--){
                if(r==0) {
                    snakeXlength[r] = snakeXlength[r] - 25;
                }else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                if(snakeXlength[r]<25){
                    snakeXlength[r]=850;
                }
            }
            repaint();
        }
        if(down){
            for(int r=lengthOfSnake-1; r >=0 ;r--){
                snakeXlength[r+1]=snakeXlength[r];
            }
            for(int r=lengthOfSnake;r>=0;r--){
                if(r==0) {
                    snakeYlength[r] = snakeYlength[r] + 25;
                }else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if(snakeYlength[r]>626){
                    snakeYlength[r]=75;
                }
            }
            repaint();
        }
        if(up){
            for(int r=lengthOfSnake-1; r >=0 ;r--){
                snakeXlength[r+1]=snakeXlength[r];
            }
            for(int r=lengthOfSnake;r>=0;r--){
                if(r==0) {
                    snakeYlength[r] = snakeYlength[r] - 25;
                }else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if(snakeYlength[r]<75){
                    snakeYlength[r]=626;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right=true;
            if(!left) {
                right=true;
            }else {
                right=false;
                left = true;
            }
            up=false;
            down=false;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left=true;
            if(!right) {
                left=true;
            }else {
                left=false;
                right = true;
            }
            up=false;
            down=false;
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            right = false;
            left = false;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down=true;
            if(!up) {
                down=true;
            }else {
                down=false;
                up = true;
            }
            right=false;
            left=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
