import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Vendor implements Runnable {
    private int totalTickets;
    private int ticketReleaseRate;
    private TicketPool ticketPool;

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        // Create a list of ticket IDs from 1 to totalTickets
        List<Integer> ticketIds = new ArrayList<>();
        for (int i = 1; i <= totalTickets; i++) {
            ticketIds.add(i);
        }

        // Shuffle the ticket IDs to randomize the order
        Collections.shuffle(ticketIds);

        // Add tickets to the pool in the shuffled order
        for (int id : ticketIds) {
            Ticket ticket = new Ticket("Simple Event", new BigDecimal("1000"));
            ticketPool.addTicket(ticket);  // Add unique ticket to the pool
            try {
                Thread.sleep(ticketReleaseRate * 1000);  // Simulate delay between releases
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}