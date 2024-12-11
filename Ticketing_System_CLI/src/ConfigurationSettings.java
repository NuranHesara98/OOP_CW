import java.util.Scanner;

public class ConfigurationSettings {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public ConfigurationSettings() {
        setConfigurations();
    }

    // Method to set configurations interactively
    public void setConfigurations() {
        Scanner scanner = new Scanner(System.in);

        // Handle totalTickets input
        while (true) {
            try {
                System.out.print("Enter the total number of tickets: ");
                this.totalTickets = Integer.parseInt(scanner.nextLine());

                if (this.totalTickets <= 0) {
                    System.out.println("Error: Total tickets must be a positive integer.");
                    continue;
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }

        // Handle ticketReleaseRate input
        while (true) {
            try {
                System.out.print("Enter the ticket release rate (in seconds): ");
                this.ticketReleaseRate = Integer.parseInt(scanner.nextLine());

                if (this.ticketReleaseRate <= 0) {
                    System.out.println("Error: Ticket release rate must be a positive integer.");
                    continue;
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }

        // Handle customerRetrievalRate input
        while (true) {
            try {
                System.out.print("Enter the customer retrieval rate (in seconds): ");
                this.customerRetrievalRate = Integer.parseInt(scanner.nextLine());

                if (this.customerRetrievalRate <= 0) {
                    System.out.println("Error: Customer retrieval rate must be a positive integer.");
                    continue;
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }

        // Handle maxTicketCapacity input
        while (true) {
            try {
                System.out.print("Enter the maximum ticket capacity: ");
                this.maxTicketCapacity = Integer.parseInt(scanner.nextLine());

                if (this.maxTicketCapacity <= 0) {
                    System.out.println("Error: Maximum ticket capacity must be a positive integer.");
                    continue;
                }
                break; // Exit loop if input is valid
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    @Override
    public String toString() {
        return "ConfigurationSettings{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
