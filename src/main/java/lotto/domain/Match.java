package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Match {
    private final Random RANDOM = new Random();
    private final List<Ticket> tickets;
    private Winners winners = null;

    public Match() {
        this.tickets = new ArrayList<>();
    }

    public void purchase(int count) {
        for(int i = 0; i< count; i++) {
            addTicket(new Ticket(issuance()));
        }
    }
    private List<Integer> issuance() {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0 ; i<6 ; i++) {
            numbers.add(RANDOM.nextInt(46));
        }
        return numbers;
    }

    private void addTicket(Ticket ticket) {
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
