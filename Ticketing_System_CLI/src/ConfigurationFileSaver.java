import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;

public class ConfigurationFileSaver {

    private static final String COUNTER_FILE = "last_used_number.txt";  // File to store the last used number
    private static final String FILE_NAME_PREFIX = "Config.json_";  // Prefix for the JSON file name

    // Method to get the next available unique file number
    private int getNextFileNumber() {
        int lastNumber = 0;

        // Read the last used number from the file
        File counterFile = new File(COUNTER_FILE);
        if (counterFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(counterFile))) {
                String lastUsed = reader.readLine();
                if (lastUsed != null && !lastUsed.isEmpty()) {
                    lastNumber = Integer.parseInt(lastUsed);
                }
            } catch (IOException e) {
                System.out.println("Error reading counter file: " + e.getMessage());
            }
        }

        // Increment the number
        int newNumber = lastNumber + 1;

        // Write the new number back to the counter file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile))) {
            writer.write(Integer.toString(newNumber));
        } catch (IOException e) {
            System.out.println("Error writing to counter file: " + e.getMessage());
        }

        return newNumber;
    }

    // Method to save configuration to a JSON file using Gson
    public void saveToJsonFile(ConfigurationSettings config) {
        int nextFileNumber = getNextFileNumber();  // Get the next available file number

        // Format the file name (e.g., Config.json_001)
        String fileName = String.format(FILE_NAME_PREFIX + "%03d", nextFileNumber);

        Gson gson = new Gson();
        JsonObject configJson = new JsonObject();
        configJson.addProperty("totalTickets", config.getTotalTickets());
        configJson.addProperty("ticketReleaseRate", config.getTicketReleaseRate());
        configJson.addProperty("customerRetrievalRate", config.getCustomerRetrievalRate());
        configJson.addProperty("maxTicketCapacity", config.getMaxTicketCapacity());

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(configJson, fileWriter);
            System.out.println("Configurations saved to JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }

    // Method to save configuration to a plain text file
    public void saveToTextFile(ConfigurationSettings config, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Total Tickets: " + config.getTotalTickets());
            writer.newLine();
            writer.write("Ticket Release Rate (in seconds): " + config.getTicketReleaseRate());
            writer.newLine();
            writer.write("Customer Retrieval Rate (in seconds): " + config.getCustomerRetrievalRate());
            writer.newLine();
            writer.write("Max Ticket Capacity: " + config.getMaxTicketCapacity());
            writer.newLine();

            System.out.println("Configurations saved to text file.");
        } catch (IOException e) {
            System.out.println("Error writing to text file: " + e.getMessage());
        }
    }
}
