package step2.domain;

import java.util.Objects;

public class Ticket {
    private static final int ZERO_COUNT = 0;
    private final long ticketCount;

    public Ticket(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    public Ticket(Ticket ticket) {
        this.ticketCount = ticket.ticketCount;
    }

    public long ticketCount() {
        return this.ticketCount;
    }

    public boolean having() {
        return this.ticketCount > ZERO_COUNT;
    }

    public Ticket deductedTicket() {
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
