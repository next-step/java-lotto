package lotto.domain;

import java.util.List;
import lotto.domain.exception.NullTicketsException;
import lotto.domain.exception.OutOfTicketIndexException;
import lotto.domain.number.Ticket;

public class TicketBox {

    private final List<Ticket> tickets;

    public TicketBox(List<Ticket> tickets) {
        if (tickets == null) {
            throw new NullTicketsException();
        }
        this.tickets = tickets;
    }

    public Ticket getTicket(int index) {
        if (tickets.size() <= index) {
            throw new OutOfTicketIndexException();
        }
        return tickets.get(index);
    }

    public int getSize() {
        return tickets.size();
    }
}
