
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, Runnable {

    private Timer timer;

    private Thread thread;

    private int delay = 9;

    private int playerX = 310;

    private static int score = 0, yCoor = 0, getYCoor = 0;

    private int getSpeed = 0;

    private Random random;

    private int[] yCoorDizi = {10, 50, 80, 90, 110, 150, 230, 280, 320, 350, 400, 420, 470, 520};

    private boolean sendButton = false, start = false;

    private ArrayList<Rectangle> bullets = new ArrayList<>();

    private ArrayList<Rectangle> ballons = new ArrayList<>();

    private Rectangle kutu;

    public GamePlay() {
        thread = new Thread(this);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        kutu = new Rectangle(playerX, 550, 15, 100);

        random = new Random();

        addBallon(true);
        addBallon(true);
        addBallon(true);
        addBallon(true);

        thread.start();

    }

    public void addBallon(boolean start) {
        int width = 40;
        yCoor = random.nextInt(yCoorDizi.length - 1);
        getYCoor = yCoorDizi[yCoor];

        if (start) {
            ballons.add(new Rectangle(getYCoor, 0, width, width));
        } else {
            ballons.add(new Rectangle(getYCoor, ballons.get(ballons.size() - 1).x - 200, width, width));
        }
    }

    public void fire() {
        addBullet();
    }

    public void boxsend(boolean sendButtonn) {
        if (sendButtonn) {
            kutu.x -= 3;
        } else {
            kutu.x += 3;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 692);

        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 5, 692);
        g.fillRect(0, 0, 692, 5);
        g.fillRect(691, 0, 5, 691);

        g.setColor(Color.GREEN);
        g.fillRect(kutu.x, kutu.y, kutu.width, kutu.height);

        if (start) {

            for (Rectangle bullet : bullets) {
                drawBullet(g, bullet);
            }

            for (Rectangle ballon : ballons) {
                drawBallon(g, ballon);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Verdana", Font.BOLD, 25));
            g.drawString("Score : " + score, 500, 60);

        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Verdana", Font.BOLD, 25));
            g.drawString("Oyuna Başlamak İçin Enter'a basın.", 100, 200);
            score = 0;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire();
            System.out.println("ateşlendi");
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            sendButton = false;
            boxsend(sendButton);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            sendButton = true;
            boxsend(sendButton);
        }
        
        if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            start=true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void addBullet() {
        bullets.add(new Rectangle(kutu.x, kutu.y, 10, 10));
    }

    private void drawBallon(Graphics g, Rectangle ballon) {
        g.setColor(Color.RED);
        g.fillRect(ballon.x, ballon.y, ballon.width, ballon.height);
    }

    private void drawBullet(Graphics g, Rectangle bullet) {
        g.setColor(Color.YELLOW);
        g.fillOval(bullet.x, bullet.y, bullet.width, bullet.height);
    }

    @Override
    public void run() {
        getSpeed = random.nextInt(5);
        for (;;) {

            boxsend(sendButton);

            for (int i = 0; i < bullets.size(); i++) {
                Rectangle bullet = bullets.get(i);
                bullet.y -= 3;

            }

            for (int i = 0; i < ballons.size(); i++) {
                Rectangle ballon = ballons.get(i);
                ballon.y += getSpeed;
            }

            for (int i = 0; i < ballons.size(); i++) {
                Rectangle ballon = ballons.get(i);
                if (ballon.y + ballon.height > 650) {
                    ballons.remove(ballon);
                    if (ballon.x > 10 || ballon.y > 0) {
                        addBallon(false);
                    }
                }
            }

            for (int i = 0; i < bullets.size(); i++) {

                Rectangle bullet = bullets.get(i);

                for (int j = 0; j < ballons.size(); j++) {
                    Rectangle ballon = ballons.get(j);
                    if (ballon.y + ballon.height > 600) {
                        ballons.remove(ballon);
                        if (ballon.y > 0 || ballon.x > 0) {
                            addBallon(false);
                        }
                    }

                    if (ballon.intersects(bullet)) {
                        score++;
                        bullets.remove(bullet);
                        ballons.remove(ballon);
                        if (ballon.y > 0) {
                            addBallon(false);
                        }
                    }

                    if (kutu.intersects(ballon)) {
                        System.out.println("oyun bitti");
                        start=false;
                        score=0;
                    }

                }

            }
            
             repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
            }

           
        }
    }

}
