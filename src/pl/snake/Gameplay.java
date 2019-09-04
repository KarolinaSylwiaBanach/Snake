package pl.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private JButton restart=new JButton("Restart");
    private int[] snakeXlength = new int[1500];
    private int[] snakeYlength = new int[1500];
    private int[] appleXpos = {50, 100, 150, 200,
            250, 300, 350, 400, 450, 500, 550, 600,
            650, 700, 750, 800, 850, 900, 950, 1000,
            1050, 1100, 1150, 1200, 1250, 1300, 1350, 1400};
    private int[] appleYpos = {100, 150, 200, 250, 300, 350,
            400, 450, 500, 550, 600, 650, 700, 750, 800};

    private Random random = new Random();
    private int xpos = random.nextInt(29);
    private int ypos = random.nextInt(15);

    private int lengthOfSnake = 1;
    private int moves = 0;
    private int score = 0;

    private Timer timer;
    private int delay = 100;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon titleImage = new ImageIcon("title.png");
    private ImageIcon downHeadImage = new ImageIcon("downhead.png");
    private ImageIcon upHeadImage = new ImageIcon("uphead.png");
    private ImageIcon leftHeadImage = new ImageIcon("lefthead.png");
    private ImageIcon rightHeadImage = new ImageIcon("righthead.png");
    private ImageIcon snakeImage = new ImageIcon("snake.png");
    private ImageIcon appleImage = new ImageIcon("apple.png");


    public Gameplay() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        for (int i=1;i<lengthOfSnake ;i++){
            if (snakeXlength[i]== snakeXlength[0] && snakeYlength[i] == snakeYlength[0]){
                right= false;
                left= false;
                up= false;
                down= false;
                JOptionPane.showMessageDialog(null, "Game Over, you scored "+score+" points");
                score=0;
                moves=0;
                lengthOfSnake=1;
            }
        }
        if (moves == 0) {
            snakeXlength[0] = 50;
            snakeYlength[0] = 100;
        }

        //draw title
        g.setColor(Color.white);
        g.drawRect(50, 10, 1401, 80);
        titleImage.paintIcon(this, g, 51, 11);

        //draw gameplay
        g.setColor(Color.WHITE);
        g.fillRect(50, 100, 1400, 750);

        //draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Curlz MT", Font.PLAIN, 30));
        g.drawString("SCORE: " + score, 1300, 60);
        rightHeadImage.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);

        for (int a = 0; a < lengthOfSnake; a++) {
            if (a == 0 && right) {
                rightHeadImage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
            } else if (a == 0 && left) {
                leftHeadImage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
            } else if (a == 0 && up) {
                upHeadImage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
            } else if (a == 0 && down) {
                downHeadImage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
            }
            if (a != 0) {
                snakeImage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
            }
        }

        if (appleXpos[xpos] == snakeXlength[0] && appleYpos[ypos] == snakeYlength[0]) {
            lengthOfSnake++;
            score++;
            xpos = random.nextInt(29);
            ypos = random.nextInt(15);
        }
        appleImage.paintIcon(this, g, appleXpos[xpos], appleYpos[ypos]);



        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (right) {
            for (int r = lengthOfSnake - 1; r >= 0; r--) {
                snakeYlength[r + 1] = snakeYlength[r];
            }
            for (int r = lengthOfSnake; r >= 0; r--) {
                if (r == 0) {
                    snakeXlength[r] = snakeXlength[r] + 50;
                } else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                if (snakeXlength[r] > 1400) {
                    snakeXlength[r] = 50;
                }
            }
            repaint();
        }
        if (left) {
            for (int r = lengthOfSnake - 1; r >= 0; r--) {
                snakeYlength[r + 1] = snakeYlength[r];
            }
            for (int r = lengthOfSnake; r >= 0; r--) {
                if (r == 0) {
                    snakeXlength[r] = snakeXlength[r] - 50;
                } else {
                    snakeXlength[r] = snakeXlength[r - 1];
                }
                if (snakeXlength[r] < 50) {
                    snakeXlength[r] = 1400;
                }
            }
            repaint();
        }
        if (down) {
            for (int r = lengthOfSnake - 1; r >= 0; r--) {
                snakeXlength[r + 1] = snakeXlength[r];
            }
            for (int r = lengthOfSnake; r >= 0; r--) {
                if (r == 0) {
                    snakeYlength[r] = snakeYlength[r] + 50;
                } else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if (snakeYlength[r] > 800) {
                    snakeYlength[r] = 100;
                }
            }
            repaint();
        }
        if (up) {
            for (int r = lengthOfSnake - 1; r >= 0; r--) {
                snakeXlength[r + 1] = snakeXlength[r];
            }
            for (int r = lengthOfSnake; r >= 0; r--) {
                if (r == 0) {
                    snakeYlength[r] = snakeYlength[r] - 50;
                } else {
                    snakeYlength[r] = snakeYlength[r - 1];
                }
                if (snakeYlength[r] < 100) {
                    snakeYlength[r] = 800;
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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
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
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            right = false;
            left = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
