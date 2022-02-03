package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

    private final List<Ticket> ticketList;

    public Tickets() {
        ticketList = new ArrayList<>();
    }

    public List<Ticket> get() {
        return ticketList;
    }

    public void addTicket(final Ticket ticket) {
        ticketList.add(ticket);
    }

}
