package comparadorpc;

import javax.swing.JFrame;
import java.awt.*;;

public class MainContainer extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenWidth;
    double screenHeight;

    int activeProportion = 0;
    double[] proportionRatios = {
        1,
        0.8,
        0.6,
        0.4,
        0.2
    };

    private void assignWindowSize(int newProportions) {
        activeProportion = newProportions;
        screenWidth = screenSize.getWidth() * proportionRatios[activeProportion];
        screenHeight = screenSize.getHeight() * proportionRatios[activeProportion];
        
        this.setSize(((int)screenWidth), ((int)screenHeight));
    } 
    
    public void begin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Proyecto 1 - Sistemas Operativos - Cermeño y Camacho");
        this.setResizable(false);
        this.assignWindowSize(0);
        this.setVisible(true);
    }
}
