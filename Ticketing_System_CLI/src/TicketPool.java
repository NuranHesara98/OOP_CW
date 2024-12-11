import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private int maximumTicketCapacity;
    private Queue<Ticket> ticketQueue;

    public TicketPool(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maximumTicketCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ticketQueue.add(ticket);
        notifyAll();
        System.out.println("Ticket added - Ticket ID: " + ticket.getTicketId() + " - current size is - " + ticketQueue.size());
    }

    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Ticket ticket = ticketQueue.poll();
        notifyAll();

        // This is where the ticket purchase message is printed
        System.out.println("Ticket bought - Ticket ID: " + ticket.getTicketId() + " - current size is - " + ticketQueue.size());
        return ticket;
    }

    public synchronized int getQueueSize() {
        return ticketQueue.size();
    }
}
