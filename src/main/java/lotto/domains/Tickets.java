package lotto.domains;

import java.util.ArrayList;
import java.util.List;

import lotto.enums.Prize;
import lotto.exceptions.NullTicketsException;

public class Tickets {

    private static final int TICKET_PRICE = 1000;

    private List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        if (tickets == null) {
            throw new NullTicketsException();
        }

        this.tickets = tickets;
    }

    public int size() {
        return this.tickets.size();
    }

    public int payment() {
        return size() * TICKET_PRICE;
    }

    public void append(Tickets other) {
        List<Ticket> newTickets = new ArrayList<>(this.tickets);
        newTickets.addAll(other.tickets);
        this.tickets = newTickets;
    }

    public Scores scores(WinningNumbers winningNumbers) {
        Scores scores = new Scores();

        for (Ticket ticket : this.tickets) {
            Prize key = winningNumbers.classifyPrize(ticket);
            scores.increase(key);
        }

        return scores;
    }

    public String print() {
        StringBuilder message = new StringBuilder();
        for (Ticket ticket : this.tickets) {
            message.append(ticket.toString()).append(System.lineSeparator());
        }
        return message.toString();
    }
}
