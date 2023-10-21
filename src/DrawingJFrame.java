import javax.swing.*;

public class DrawingJFrame extends JFrame {

    DrawingJFrame(){
        this.add(new DrawingJPanel());
        this.setTitle("Button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
