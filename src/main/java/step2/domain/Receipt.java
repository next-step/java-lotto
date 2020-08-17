package step2.domain;

import java.util.List;

public class Receipt {

    private Money change;

    private List<Ticket> tickets;

    public Receipt(final int change, final List<Ticket> tickets) {
        this.change = new Money(change);
        this.tickets = tickets;
    }

    public Money getChange() {
        return change;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
