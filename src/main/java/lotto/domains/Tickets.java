package lotto.domains;

import java.util.ArrayList;
import java.util.List;

import lotto.enums.Prize;
import lotto.exceptions.NullTicketsException;

public class Tickets {

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

    public Tickets append(Tickets other) {
        List<Ticket> newTickets = new ArrayList<>(this.tickets);
        newTickets.addAll(other.tickets);
        return new Tickets(newTickets);
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
