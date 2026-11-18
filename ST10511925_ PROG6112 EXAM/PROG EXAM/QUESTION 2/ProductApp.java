import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Menu System - Q2.4
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSale());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Q2.2 - Form objects
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        add(btnProcess);

        setVisible(true);
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Message Box - Q2.3 - EXACT format from screenshot
            String message = "Customer Name: " + customerName +
                    "\nProduct: " + productName +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt - Q2.3
            try (FileWriter writer = new FileWriter("data.txt", true)) {
                writer.write("DATA LOG\n");
                writer.write("***************************\n");
                writer.write("Customer Name: " + customerName + "\n");
                writer.write("Product: " + productName + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("***************************\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new ProductApp();
    }
}