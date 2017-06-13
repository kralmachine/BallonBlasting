
import javax.swing.JFrame;

public class Main {
       public static void main(String[] args){
           JFrame frame=new JFrame();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setTitle("Ballon Blasting!");
           frame.setBounds(10,10,700,700);
           frame.setLocationRelativeTo(null);
           frame.setResizable(false);
           GamePlay gamePlay=new GamePlay();
           frame.add(gamePlay);
           frame.setVisible(true);
       }
}
