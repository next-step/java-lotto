package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final List<Ticket> tickets;
    private Winners winners = null;

    public Match() {
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<String> renderingTickets() {
        return null;
    }

    public void winningTicket(Ticket winningTicket) {
        winners = new Winners(
                aggregateFirst(winningTicket),
                -1,
                aggregateThird(winningTicket),
                aggregateforth(winningTicket),
                aggregateFitft(winningTicket)
        );
    }

    private int aggregateThird(Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateforth(Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFitft(Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFirst(Ticket winningTicket) {
        throw new RuntimeException();
    }

    public List<Integer> winnerStatus() {
        return winners.winnerCount();
    }

    public double returnRate() {
        throw new RuntimeException();
    }
}
