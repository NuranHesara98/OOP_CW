public class Main {
    public static void main(String[] args) {
        // Initialize ConfigurationSettings and ConfigurationFileSaver
        ConfigurationSettings config = new ConfigurationSettings();

        // Optionally, print out the configuration to verify it's correct
        System.out.println(config);

        // Now use ConfigurationFileSaver to save the configuration to JSON and Text files
        ConfigurationFileSaver fileSaver = new ConfigurationFileSaver();
        fileSaver.saveToJsonFile(config);

        // Directly set the configurations
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Define the number of vendors
        int numberOfVendors = 1;
        int ticketsPerVendor = config.getTotalTickets() / numberOfVendors;

        // Create and start vendor threads using user-configured parameters
        Vendor[] vendors = new Vendor[numberOfVendors];
        Thread[] vendorThreads = new Thread[vendors.length];
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(ticketsPerVendor, config.getTicketReleaseRate(), ticketPool);
            vendorThreads[i] = new Thread(vendors[i], "Vendor ID-" + i);
            vendorThreads[i].start();
        }

        // Create and start customer threads using user-configured parameters
        Customer[] customers = new Customer[config.getTotalTickets()];
        Thread[] customerThreads = new Thread[customers.length];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool, config.getCustomerRetrievalRate(), 1);
            customerThreads[i] = new Thread(customers[i], "Customer ID-" + i);
            customerThreads[i].start();
        }

        // Wait for vendor threads to finish
        try {
            for (Thread vendorThread : vendorThreads) {
                vendorThread.join();
            }

            // Wait for customer threads to finish
            for (Thread customerThread : customerThreads) {
                customerThread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Log the system operations completion
        Logger.logSystemOutput("System operations are completed.");
        Logger.logSystemOutput("Final ticket pool size: " + ticketPool.getQueueSize());
    }
}
