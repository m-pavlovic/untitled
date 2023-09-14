import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {

    JTextField nameField;
    JTextField surnameField;
    JLabel nameLabel;
    JLabel surnameLabel;
    JButton button;
    JRadioButton usaButton;
    JRadioButton euButton;
    ButtonGroup buttonGroup;

    ViewPanel() {
        setVisible(true);
        setLayout(null);
        //setBounds(0, 0, 670, 200);
        setBounds(0, 0, 670, 200);
        setBackground(Color.LIGHT_GRAY);
        initComps();
        layoutComps();
        activateComps();
    }

    private void initComps() {
        nameField = new JTextField();
        surnameField = new JTextField();
        nameLabel = new JLabel("Name:");
        surnameLabel = new JLabel("Surname:");
        button = new JButton("Submit");
        usaButton = new JRadioButton("USA");
        euButton = new JRadioButton("EU");
        buttonGroup = new ButtonGroup();

    }

    private void layoutComps() {
        nameField.setBounds(350, 20, 150, 20);
        surnameField.setBounds(350, 50, 150, 20);
        nameLabel.setBounds(220, 20, 100, 20);
        surnameLabel.setBounds(220, 50, 100, 20);
        button.setBounds(400, 130, 100, 20);
        usaButton.setBounds(150, 100, 100, 20);
        euButton.setBounds(150, 130, 100, 20);
        buttonGroup.add(usaButton);
        buttonGroup.add(euButton);
        add(nameField);
        add(surnameField);
        add(nameLabel);
        add(surnameLabel);
        add(button);
        add(usaButton);
        add(euButton);
    }

    private void activateComps() {
        button.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String country = "";
            if (usaButton.isSelected()) {
                country = "USA";
            } else if (euButton.isSelected()) {
                country = "EU";
            }
            System.out.println("Name: " + name + "\nSurname: " + surname + "\nCountry: " + country);
            resetForm();
        });

    }

    private void resetForm() {
        nameField.setText("");
        surnameField.setText("");
        buttonGroup.clearSelection();
    }
}
