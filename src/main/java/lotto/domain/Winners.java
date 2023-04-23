package lotto.domain;

import java.util.List;

public class Winners {
    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countFirst;

    private final int income;


    public Winners(List<Ticket> tickets, Ticket winningTicket) {
        this.countFirst = aggregateFirst(tickets,winningTicket);
        this.countThird = aggregateThird(tickets,winningTicket);
        this.countFourth = aggregateFourth(tickets,winningTicket);
        this.countFifth = aggregateFifth(tickets,winningTicket);
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

    private int aggregateFourth(List<Ticket> tickets, Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFifth(List<Ticket> tickets, Ticket winningTicket) {
        throw new RuntimeException();
    }

    private int aggregateFirst(List<Ticket> tickets,Ticket winningTicket) {
        throw new RuntimeException();
    }

    public int getCountFifth() {
        return countFifth;
    }

    public int getCountFourth() {
        return countFourth;
    }

    public int getCountThird() {
        return countThird;
    }

    public int getCountFirst() {
        return countFirst;
    }

    public double returnRatio() {
        throw new RuntimeException("투자금대비 당첨금 비율");
    }
}
