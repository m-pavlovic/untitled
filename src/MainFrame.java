import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainFrame extends JFrame implements ActionListener {

    private ViewPanel panel;
    private UpperPanel upperPanel;
    private JPanel mainPanel;
    private JLabel label;


    MainFrame() {
        super("Simple GUI App");
        setSize(670, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComps();
        layoutComps();
        activateApp();
        setVisible(true);
    }


    public void initComps() {
        upperPanel = new UpperPanel();
        mainPanel = new JPanel();
        panel = new ViewPanel();
        label = new JLabel("FORM");

    }

    public void layoutComps() {
        setLayout(null);
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 170, 670, 200);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setBounds(0, 0, 670, 200);
        label.setVerticalAlignment(1);
        label.setHorizontalAlignment(2);
        add(mainPanel);
        mainPanel.add(label);
        mainPanel.add(panel);
        add(upperPanel);

    }

    public void activateApp() {
        panel.button.addActionListener(this);
    }

    public void saveToFile() throws IOException {
        File file = new File("data.txt");
        if (!file.exists()) {
            file.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(upperPanel.textArea.getText());
        } else {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
            oos.writeObject(upperPanel.textArea.getText());
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = panel.nameField.getText();
        String surname = panel.surnameField.getText();
        String country = "";
        if (panel.usaButton.isSelected()) {
            country = "USA";
        } else if (panel.euButton.isSelected()) {
            country = "EU";
        }
        String result = "Name: " + name + "\nSurname: " + surname + "\nCountry: " + country + "\n" + "----------------------------" + "\n";
        upperPanel.textArea.setText(result);
        try {
            saveToFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
