package lotto.domain;

import java.util.List;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int count() {
        return tickets.size();
    }
}
