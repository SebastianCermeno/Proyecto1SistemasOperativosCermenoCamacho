package comparadorpc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;;

public class MainContainer extends JFrame {
    private class ButtonContainer extends JPanel {
        MainContainer parent;
        ButtonBlock segmentButtons[] = new ButtonBlock[4];
        ButtonContainer(MainContainer father){
            parent = father;
            this.setSize((int)(parent.getWidth()*0.2), parent.getHeight());
            ButtonBlock blockA = new ButtonBlock(this, 0, "Dell");
            ButtonBlock blockB = new ButtonBlock(this, 1, "MSI");
            ButtonBlock blockC = new ButtonBlock(this, 2, "Opciones");
            ButtonBlock blockD = new ButtonBlock(this, 3, "Gráficos");

            segmentButtons[0] = blockA;
            segmentButtons[1] = blockB;
            segmentButtons[2] = blockC;
            segmentButtons[3] = blockD;

            this.add(blockA);
            blockA.setBounds(0, (int)(this.getHeight() * 0), blockA.getWidth(), blockA.getHeight());
            this.add(blockB);
            blockB.setBounds(0,(int)(this.getHeight() * 0.25),blockA.getWidth(), blockA.getHeight());
            this.add(blockC);
            blockC.setBounds(0,(int)(this.getHeight() * 0.50),blockA.getWidth(), blockA.getHeight());
            this.add(blockD);
            blockD.setBounds(0,(int)(this.getHeight() * 0.75),blockA.getWidth(), blockA.getHeight());

            this.setBackground(Color.RED);
        }

        public void arrangeActive(int newActive) {
            for (int i = 0; i<segmentButtons.length; i++) {
                if (i == newActive){
                    segmentButtons[i].localButton.setSize((int)(segmentButtons[i].getWidth()*0.9), segmentButtons[i].getHeight());
                }
                else {
                    segmentButtons[i].localButton.setSize((int)(segmentButtons[i].getWidth()*0.7), segmentButtons[i].getHeight());
                }
            }
        }
    }

    private class ButtonBlock extends JPanel implements MouseListener{
        private class OperatorButton extends JButton {
            ButtonBlock holder;
            int controlledTabIndex;
            OperatorButton(ButtonBlock father, int indexOfTab, String buttonText){
                holder = father;
                this.setText(buttonText);
                controlledTabIndex = indexOfTab;
                this.setSize((int)(father.getWidth()*0.7), father.getHeight());
                this.setVisible(true);
            }
        }

        OperatorButton localButton;
        ButtonContainer parent;

        ButtonBlock(ButtonContainer father, int buttonIndex, String entrytext){
            parent = father;
            this.setSize(father.getWidth(), (int)(father.getHeight()*0.25));
            this.setBackground(Color.CYAN);
            this.addMouseListener(this);

            localButton = new OperatorButton(this, buttonIndex, entrytext);
            this.add(localButton);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            return;
            // throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            return;
            // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            return;
            // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            parent.arrangeActive(localButton.controlledTabIndex);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            return;
        }
    }

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
        this.setLayout(new BorderLayout());

        ButtonContainer sidePanel = new ButtonContainer(this);
        this.add(sidePanel, BorderLayout.WEST);
    }
}
