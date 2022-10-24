package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.exception.InvalidTicketsException;
import lotto.domain.exception.NullTicketBoxException;
import lotto.domain.number.Ticket;

public class TicketBox {

    private final Set<Ticket> tickets;

    public TicketBox(List<Ticket> tickets) {
        if (tickets == null
                || new HashSet<>(tickets).size() < tickets.size()) {
            throw new InvalidTicketsException();
        }

        this.tickets = new LinkedHashSet<>(tickets);
    }

    public List<Ticket> getTickets() {
        return tickets.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public int getSize() {
        return tickets.size();
    }

    public static TicketBox merge(TicketBox ticketBox1, TicketBox ticketBox2) {
        if (ticketBox1 == null || ticketBox2 == null) {
            throw new NullTicketBoxException();
        }

        List<Ticket> mergeTickets = new ArrayList<>();
        mergeTickets.addAll(ticketBox1.getTickets());
        mergeTickets.addAll(ticketBox2.getTickets());
        return new TicketBox(mergeTickets);
    }
}
