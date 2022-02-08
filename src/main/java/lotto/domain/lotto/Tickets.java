package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Tickets {

    private final List<Ticket> tickets;

    public Tickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> get() {
        return Collections.unmodifiableList(tickets);
    }

    public int count() {
        return tickets.size();
    }

}
