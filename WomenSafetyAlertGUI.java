 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;

public class WomenSafetyAlertGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Women Safety Alert System");
        JButton sosButton = new JButton("HELP");

        // Button design
        sosButton.setBackground(Color.RED);
        sosButton.setForeground(Color.WHITE);
        sosButton.setFont(new Font("Arial", Font.BOLD, 40));

        sosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get IP address
                String ipAddress = "Unknown";
                try {
                    InetAddress ip = InetAddress.getLocalHost();
                    ipAddress = ip.getHostAddress();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                String alertMessage = "ALERT: Emergency signal sent from Jaipur, Rajasthan at 7:30 PM\n"
                        + "IP Address: " + ipAddress + "\n"
                        + "Message sent to Guardian.";

                // Show popup
                JOptionPane.showMessageDialog(frame, alertMessage, "Emergency Alert", JOptionPane.WARNING_MESSAGE);

                // Save to log
                try {
                    FileWriter writer = new FileWriter("alert_log.txt", true);
                    writer.write(alertMessage + "\n\n");
                    writer.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving alert to log file.");
                }

                // Placeholder for future SMS/WhatsApp API integration
                System.out.println(">> Future: SMS/WhatsApp API can be added here.");
            }
        });

        frame.add(sosButton);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
