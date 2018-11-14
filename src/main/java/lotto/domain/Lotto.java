package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Ticket> tickets = new ArrayList<>();

    public void addTickets(List<Ticket> ticket) {
        this.tickets.addAll(ticket);
    }

    public List<Ticket> findLottos() {
        return tickets;
    }
}
