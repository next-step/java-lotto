package lotto.domain;

import java.util.List;

public class Winners {
    private final int countFitft;
    private final int countforth;
    private final int countThird;
    private final int countFirst;

    private final int income;


    public Winners(List<Ticket> tickets, Ticket winningTicket) {
        this.countFirst = aggregateFirst(tickets,winningTicket);
        this.countThird = aggregateThird(tickets,winningTicket);
        this.countforth = aggregateforth(tickets,winningTicket);
        this.countFitft = aggregateFitft(tickets,winningTicket);
        this.income = aggregateIncome();
    }

    private int aggregateIncome() {
        throw new RuntimeException();
    }

    public int getIncome() {
        return income;
    }

    private int aggregateThird(List<Ticket> tickets, Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateforth(List<Ticket> tickets,Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFitft(List<Ticket> tickets,Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFirst(List<Ticket> tickets,Ticket winningTicket) {
        throw new RuntimeException();
    }


    public List<Integer> winnerCount() {
        return List.of(countFirst, countThird, countforth, countFitft);
    }
}
