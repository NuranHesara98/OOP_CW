import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String LOG_FILE = "LOG_001.txt"; // Define the log file name

    // Log the configuration settings to the log file
    public static void logConfiguration(ConfigurationSettings config) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write("");
            writer.write("Configuration Parameters:\n");
            writer.write("Total Tickets: " + config.getTotalTickets() + "\n");
            writer.write("Ticket Release Rate (in seconds): " + config.getTicketReleaseRate() + "\n");
            writer.write("Customer Retrieval Rate (in seconds): " + config.getCustomerRetrievalRate() + "\n");
            writer.write("Max Ticket Capacity: " + config.getMaxTicketCapacity() + "\n\n");
            writer.write("");
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Log system output (i.e., ticket addition and ticket purchase) to the log file
    public static void logSystemOutput(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timestamp + " - " + message + "\n\n");
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
