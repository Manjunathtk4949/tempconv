import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {

    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> unitComboBox;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputField = new JTextField(10);
        JLabel unitLabel = new JLabel("Select Unit:");
        String[] units = {"Celsius", "Fahrenheit"};
        unitComboBox = new JComboBox<>(units);
        JLabel outputLabel = new JLabel("Result:");
        outputField = new JTextField(10);
        outputField.setEditable(false);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(unitLabel);
        panel.add(unitComboBox);
        panel.add(outputLabel);
        panel.add(outputField);
        panel.add(new JLabel()); // Placeholder for better layout
        panel.add(convertButton);

        add(panel);
        pack();
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String selectedUnit = (String) unitComboBox.getSelectedItem();

            if (selectedUnit.equals("Celsius")) {
                double fahrenheit = (temperature * 9 / 5) + 32;
                outputField.setText(String.format("%.2f°F", fahrenheit));
            } else if (selectedUnit.equals("Fahrenheit")) {
                double celsius = (temperature - 32) * 5 / 9;
                outputField.setText(String.format("%.2f°C", celsius));
            }
        } catch (NumberFormatException e) {
            outputField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}
