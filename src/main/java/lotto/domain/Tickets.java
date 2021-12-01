package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

    private List<Ticket> tickets;

    public Tickets(int ticketsCount) {
        tickets = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            tickets.add(new Ticket());
        }
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}
