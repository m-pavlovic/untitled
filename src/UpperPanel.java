import javax.swing.*;
import java.awt.*;

public class UpperPanel extends JPanel {


    JTextArea textArea;


    UpperPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 670, 170);
        setBackground(Color.GRAY);
        initComps();
        layoutComps();
        activateComps();
    }

    private void initComps() {
        textArea = new JTextArea();
    }

    private void layoutComps() {
        textArea.setBounds(0, 0, 670, 170);
        add(textArea);
    }

    private void activateComps() {

    }
}
