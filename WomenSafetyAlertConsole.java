import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WomenSafetyAlertConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Console Mode: Women Safety Alert System ===");
        System.out.println("Press 1 to send Emergency Alert:");
        int choice = sc.nextInt();

        if (choice == 1) {
            String alertMessage = "ALERT: Emergency signal sent from Jaipur, Rajasthan at 7:30 PM\n"
                    + "Message sent to Police/Guardian.";
            System.out.println(alertMessage);

            // Save to log file
            try {
                FileWriter writer = new FileWriter("alert_log.txt", true);
                writer.write(alertMessage + "\n\n");
                writer.close();
                System.out.println("Alert saved in log file successfully!");
            } catch (IOException e) {
                System.out.println("Error saving alert to log file.");
            }
        } else {
            System.out.println("No alert sent.");
        }
        sc.close();
    }
}
