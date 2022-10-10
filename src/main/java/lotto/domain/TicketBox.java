package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.exception.InvalidTicketsException;
import lotto.domain.number.Ticket;

public class TicketBox {

    private final Set<Ticket> tickets;

    public TicketBox(List<Ticket> tickets) {
        if (tickets == null
                || new HashSet<>(tickets).size() < tickets.size()) {
            throw new InvalidTicketsException();
        }

        this.tickets = new HashSet<>(tickets);
    }

    public List<Ticket> getTickets() {
        return tickets.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public int getSize() {
        return tickets.size();
    }
}
