public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int customerRetrievalRate;  // Time delay between ticket purchases (in seconds)
    private int quantity;

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        // Initial wait before customers can start buying tickets
        try {
            Thread.sleep(customerRetrievalRate * 1000);  // Wait for the specified retrieval rate before starting
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Now start buying tickets after the initial wait
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.buyTicket();  // Wait for and buy the ticket

            // Print the message for ticket purchase (already handled by TicketPool class)
            // No additional prints here unless you want to add some custom behavior

            try {
                Thread.sleep(customerRetrievalRate * 1000);  // Simulate delay between subsequent purchases
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
