import java.math.BigDecimal;

public class Ticket {
    private static int ticketCounter = 0;  // Static counter to keep track of the last assigned ticket ID
    private int ticketId;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket(String eventName, BigDecimal ticketPrice) {
        this.ticketId = generateUniqueTicketId();  // Generate a unique ticket ID
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    // Synchronized method to ensure thread safety when generating ticket IDs
    private static synchronized int generateUniqueTicketId() {
        return ++ticketCounter;  // Increment and assign the ticket ID in a thread-safe manner
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", eventName='" + eventName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
