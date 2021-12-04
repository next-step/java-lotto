package step2.dto;

import java.util.Objects;

public class Ticket {
    private static final int BASE_PRICE = 1000;
    private static final int ZERO_COUNT = 0;
    private final int ticketCount;

    public Ticket(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Ticket(Ticket ticket) {
        this.ticketCount = ticket.ticketCount;
    }

    public int ticketCount() {
        return this.ticketCount;
    }

    public boolean having() {
        return this.ticketCount > ZERO_COUNT;
    }

    public Ticket checkingTicket() {
        return new Ticket(this.ticketCount - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return ticketCount == ticket.ticketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCount);
    }
}
