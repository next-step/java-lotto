package step2.domain;

import java.util.List;

public class Receipt {

    private int change;

    private List<Ticket> tickets;

    public Receipt(final int change, final List<Ticket> tickets) {
        this.change = change;
        this.tickets = tickets;
    }

    public int getChange() {
        return change;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
