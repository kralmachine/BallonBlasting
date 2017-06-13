package Packmen;

import javax.swing.JFrame;


public class PackmenMain extends JFrame{
    
    public static void main(String[] args) {
        JFrame frame=new JFrame("Packmen!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 750, 550);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Packmen  packmen=new Packmen();
        frame.add(packmen);
        frame.addKeyListener(packmen);
        frame.setResizable(false);
    }
    
}
