package Packmen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Packmen extends JPanel implements KeyListener, Runnable {

    private final int WIDTH = 750, HEIGHT = 550;

    private Thread thread;

    private BufferedImage image1,image2,image3,image4;

    private ArrayList<Rectangle> yemler = new ArrayList<>();

    private boolean up = true, right = false, down = false, left = false, running = false,carpmaDurum=false;

    private Rectangle kutu, yem, ortaPembe,canavar1,canavar2,canavar3;

    private ArrayList<Rectangle> tumCerceve = new ArrayList<>();

    private ArrayList<Rectangle> tumIcCerceveler = new ArrayList<>();
    
    private ArrayList<Rectangle> canavarlar=new ArrayList<>();
    
    private int x = 0, y = 0;

    public Packmen() {
        thread = new Thread(this);

        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        addTumCerceve();
        addtumIcCerceve();
        
        kutu = new Rectangle(200, 480, 20, 20);
        canavar1=new Rectangle(300, 185, 20, 20);
        canavar2=new Rectangle(350, 185, 30, 30);
        canavar3=new Rectangle(400, 185, 30, 30);
        yem = new Rectangle(165, 15, 10, 10);
        ortaPembe = new Rectangle(375, 220, 35, 5);

        canavarlar.add(canavar1);
        canavarlar.add(canavar2);
        canavarlar.add(canavar3);
        
        yemKoy1();
        yemKoy2();
        yemKoy3();
        yemKoy4();
        yemKoy5();
        yemKoy6();
        yemKoy7();
        yemKoy8();
        yemKoy9();
        yemKoy10();
        yemKoy11();
        
        thread.start();
    }

    private void yemKoy1() {
        y = 0;
        for (int i = 0; i < 7; i++) {
            addYemler(yem.x, yem.y + y);
            y += 15;
        }
    }

    private void yemKoy2() {
        y = 0;
        yem.y = 165;
        yem.x = 150;
        for (int i = 0; i < 7; i++) {

            addYemler(yem.x, yem.y + y);
            y += 15;
        }

    }

    private void yemKoy3() {
        x = 0;
        yem.x = 155;
        yem.y = 30;
        for (int i = 0; i < 13; i++) {
            addDYemler(yem.y + x, yem.x);
            x += 15;
        }

    }

    private void yemKoy4() {
        y = 0;
        yem.x = 500;
        yem.y = 30;
        for (int i = 0; i < 13; i++) {
            addYemler(yem.x, yem.y + y);
            y += 15;
        }

    }

    private void yemKoy5() {
        x = 0;
        yem.y = 340;
        yem.x = 85;
        for (int i = 0; i < 13; i++) {

            addDYemler(yem.x + x, yem.y);
            x += 15;
        }

    }

    private void yemKoy6() {
        y = 0;
        yem.y = 165;
        yem.x = 615;
        for (int i = 0; i < 8; i++) {

            addYemler(yem.x, yem.y + y);
            y += 15;
        }

    }

    private void yemKoy7() {
        x = 0;
        yem.x = 50;
        yem.y = 280;
        for (int i = 0; i < 9; i++) {
            addDYemler(yem.y + x, yem.x);
            x += 15;
        }

    }
    
    private void yemKoy8() {
        y = 0;
        yem.x=245;
        yem.y=23;
        for (int i = 0; i < 6; i++) {
            addYemler(yem.x, yem.y + y);
            y += 15;
        }
    }
    
     private void yemKoy9() {
        x = 0;
        yem.x=130;
        yem.y=80;
        for (int i = 0; i < 16; i++) {
            addDYemler(yem.x+x, yem.y );
            x += 15;
        }
    }
     
      private void yemKoy10() {
        y = 0;
        yem.x=265;
        yem.y=50;
        for (int i = 0; i < 16; i++) {
            addYemler(yem.x, yem.y+y );
            y += 15;
        }
    }
      
       private void yemKoy11() {
        x = 0;
        yem.x=200;
        yem.y=30;
        for (int i = 0; i < 14; i++) {
            addDYemler(yem.x+x, yem.y );
            x += 15;
        }
    }

    private void addYemler(int x, int y) {
        yemler.add(new Rectangle(yem.x, yem.y + y, yem.width, yem.height));
    }

    private void addDYemler(int x, int y) {
        yemler.add(new Rectangle(yem.x + x, yem.y, yem.width, yem.height));
    }

    private void drawYemler(Graphics g, Rectangle yem) {
        g.setColor(Color.YELLOW);
        g.fillOval(yem.x, yem.y, yem.width, yem.height);
    }

    private void addTumCerceve() {
        tumCerceve.add(new Rectangle(150, 20, 5, 120));
        tumCerceve.add(new Rectangle(150, 15, 470, 5));
        tumCerceve.add(new Rectangle(615, 20, 5, 120));
        tumCerceve.add(new Rectangle(150, 140, 100, 5));
        tumCerceve.add(new Rectangle(520, 140, 100, 5));
        tumCerceve.add(new Rectangle(250, 140, 5, 70));
        tumCerceve.add(new Rectangle(520, 140, 5, 70));
        tumCerceve.add(new Rectangle(135, 210, 120, 5));
        tumCerceve.add(new Rectangle(135, 250, 120, 5));
        tumCerceve.add(new Rectangle(520, 210, 120, 5));
        tumCerceve.add(new Rectangle(520, 250, 120, 5));
        tumCerceve.add(new Rectangle(250, 250, 5, 70));
        tumCerceve.add(new Rectangle(520, 250, 5, 70));
        tumCerceve.add(new Rectangle(135, 320, 120, 5));
        tumCerceve.add(new Rectangle(520, 320, 120, 5));
        tumCerceve.add(new Rectangle(135, 320, 5, 180));
        tumCerceve.add(new Rectangle(635, 320, 5, 180));
        tumCerceve.add(new Rectangle(135, 500, 505, 5));
        tumCerceve.add(new Rectangle(340, 220, 35, 5));
        tumCerceve.add(new Rectangle(410, 220, 35, 5));
        tumCerceve.add(new Rectangle(340, 225, 5, 40));
        tumCerceve.add(new Rectangle(440, 225, 5, 40));
        tumCerceve.add(new Rectangle(340, 265, 105, 5));

    }

    private void drawTumCerceve(Graphics g, Rectangle tumCerceve) {
        g.setColor(Color.BLUE.brighter());
        g.drawRect(tumCerceve.x, tumCerceve.y, tumCerceve.width, tumCerceve.height);

    }

    private void addtumIcCerceve() {
        tumIcCerceveler.add(new Rectangle(185, 50, 50, 22));
        tumIcCerceveler.add(new Rectangle(280, 50, 60, 22));
        tumIcCerceveler.add(new Rectangle(380, 20, 15, 50));
        tumIcCerceveler.add(new Rectangle(430, 50, 60, 22));
        tumIcCerceveler.add(new Rectangle(530, 50, 50, 22));
        tumIcCerceveler.add(new Rectangle(185, 100, 50, 10));
        tumIcCerceveler.add(new Rectangle(290, 105, 15, 80));
        tumIcCerceveler.add(new Rectangle(305, 140, 35, 10));
        tumIcCerceveler.add(new Rectangle(345, 105, 80, 10));
        tumIcCerceveler.add(new Rectangle(377, 115, 15, 50));
        tumIcCerceveler.add(new Rectangle(470, 105, 15, 80));
        tumIcCerceveler.add(new Rectangle(435, 140, 35, 10));
        tumIcCerceveler.add(new Rectangle(290, 240, 15, 70));
        tumIcCerceveler.add(new Rectangle(475, 240, 15, 70));
        tumIcCerceveler.add(new Rectangle(352, 300, 85, 15));
        tumIcCerceveler.add(new Rectangle(387, 315, 15, 60));
        tumIcCerceveler.add(new Rectangle(270, 370, 70, 15));
        tumIcCerceveler.add(new Rectangle(180, 375, 40, 15));
        tumIcCerceveler.add(new Rectangle(202, 390, 15, 40));
        tumIcCerceveler.add(new Rectangle(440, 370, 70, 15));
        tumIcCerceveler.add(new Rectangle(550, 375, 40, 15));
        tumIcCerceveler.add(new Rectangle(550, 390, 15, 40));
        tumIcCerceveler.add(new Rectangle(345, 420, 95, 15));
        tumIcCerceveler.add(new Rectangle(385, 435, 15, 30));
        tumIcCerceveler.add(new Rectangle(140, 450, 30, 15));
        tumIcCerceveler.add(new Rectangle(250, 450, 60, 15));
        tumIcCerceveler.add(new Rectangle(272, 420, 15, 30));
        tumIcCerceveler.add(new Rectangle(465, 450, 60, 15));
        tumIcCerceveler.add(new Rectangle(485, 420, 15, 30));
        tumIcCerceveler.add(new Rectangle(605, 450, 30, 15));
    }

    private void drawIcTumCerceve(Graphics g, Rectangle tumIcCerceve) {
        g.setColor(Color.BLUE.brighter());
        g.drawRoundRect(tumIcCerceve.x, tumIcCerceve.y, tumIcCerceve.width, tumIcCerceve.height, 10, 10);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.PINK);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString("GAME", 40, 40);
        g.drawString("SCORE", 40, 60);

        g.setColor(Color.PINK);
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        g.drawString("HIGH", 650, 40);
        g.drawString("SCORE", 650, 60);

        g.setColor(Color.PINK.brighter());
        g.setFont(new Font("Verdana", Font.PLAIN, 30));
        g.drawString("  0", 40, 100);
        g.drawString("  0", 40, 130);
        g.drawString("  0", 40, 160);
        g.drawString("  0", 40, 190);

        g.setColor(Color.PINK.brighter());
        g.setFont(new Font("Verdana", Font.PLAIN, 30));
        g.drawString("  0", 650, 100);
        g.drawString("  0", 650, 130);
        g.drawString("  0", 650, 160);
        g.drawString("  0", 650, 190);

        for (Rectangle cerceve : tumCerceve) {
            drawTumCerceve(g, cerceve);
        }

        for (Rectangle Iccerceve : tumIcCerceveler) {
            drawTumCerceve(g, Iccerceve);
        }

        g.setColor(Color.PINK);
        g.fillRect(ortaPembe.x, ortaPembe.y, ortaPembe.width, ortaPembe.height);

        try {
            image1 = ImageIO.read(getClass().getResource("packmen.png"));
            image2=ImageIO.read(getClass().getResource("canavar1.png"));
            image3=ImageIO.read(getClass().getResource("canavar2.png"));
            image4=ImageIO.read(getClass().getResource("canavar3.png"));
        } catch (Exception e) {
            System.out.println("resim hatası");

        }

        g.drawImage(image1, kutu.x, kutu.y, kutu.width, kutu.height, Color.BLACK, null);
        g.drawImage(image2, canavar1.x, canavar1.y, canavar1.width, canavar1.height, Color.BLACK, null);
       // g.drawImage(image3, canavar2.x, canavar2.y, canavar2.width, canavar2.height, Color.BLACK, null);
       // g.drawImage(image4, canavar3.x, canavar3.y, canavar3.width, canavar3.height, Color.BLACK, null);

        for (Rectangle yem : yemler) {
            drawYemler(g, yem);
        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int id = e.getKeyCode();
        if (id == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
            running = true;
        }
        if (id == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
            running = true;
        }
        if (id == KeyEvent.VK_LEFT && !right) {
            up = false;
            left = true;
            down = false;
            running = true;
        }
        if (id == KeyEvent.VK_RIGHT && !left) {
            up = false;
            right = true;
            down = false;
            running = true;
        }

        if (id == KeyEvent.VK_ENTER) {
            if (!running) {
                running = true;
            } else {
                running = false;
            }
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void hareketYap() {
        if (up) {
            kutu.y--;
        }
        if (down) {
            kutu.y++;
        }
        if (left) {
            kutu.x--;
        }
        if (right) {
            kutu.x++;
        }
    }

    @Override
    public void run() {

        for (;;) {

            if(!carpmaDurum)
                canavar1.y++;
           
           
            if (running) {
                hareketYap();
                
                for (int i = 0; i < yemler.size(); i++) {
                    Rectangle yem = yemler.get(i);
                    if (kutu.intersects(yem)) {
                        System.out.println("x :" + yem.getX() + " y :" + yem.getY());
                        yemler.remove(yem);
                    }
                }

                for (int i = 0; i < tumCerceve.size(); i++) {
                    Rectangle cerceve = tumCerceve.get(i);
                    if (kutu.intersects(cerceve)) {
                        if (up) {
                            up = false;
                        }
                        if (down) {
                            down = false;
                        }
                        if (left) {
                            left = false;
                        }
                        if (right) {
                            right = false;
                        }
                    }
                    
                    ///////////////////////////////////////
                    if(canavar1.intersects(cerceve)){
                        carpmaDurum=true;
                        canavar1.x--;
                      
                    }
                        
                   
                }

                for (int i = 0; i < tumIcCerceveler.size(); i++) {
                    Rectangle Iccerceve = tumIcCerceveler.get(i);
                    if (kutu.intersects(Iccerceve)) {
                       
                        if (up) {
                            up = false;
                        }
                        if (down) {
                            down = false;
                        }
                        if (left) {
                            left = false;
                        }
                        if (right) {
                            right = false;
                        }

                    }
                     if(canavar1.intersects(Iccerceve)){
                         carpmaDurum=true;
                         canavar1.x++;
                     }
                     
                                
                }

                if (kutu.intersects(ortaPembe)) {
                   
                    if (up) {
                        up = false;
                    }
                    if (down) {
                        down = false;
                    }
                    if (left) {
                        left = false;
                    }
                    if (right) {
                        right = false;
                    }
                }
                
           

            }
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Packmen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
