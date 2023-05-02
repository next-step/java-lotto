package lotto.domain;

import java.util.List;

public class Statics {
    private static final String PROFIT_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOSS_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final int countFifth;
    private final int countFourth;
    private final int countThird;
    private final int countSecond;
    private final int countFirst;
    private final int income;
    private final double profitRatio;

    public Statics(Tickets tickets, WinnerTicket winnerTicket) {
        this.countFirst = aggregate(tickets, winnerTicket, Prize.FIRST);
        this.countSecond = aggregate(tickets, winnerTicket, Prize.SECOND);
        this.countThird = aggregate(tickets, winnerTicket, Prize.THIRD);
        this.countFourth = aggregate(tickets, winnerTicket, Prize.FOURTH);
        this.countFifth = aggregate(tickets, winnerTicket, Prize.FIFTH);
        this.income = aggregateIncome();
        this.profitRatio = aggregateProfitRatio(tickets.count(), this.income);
    }

    private double aggregateProfitRatio(int ticketCount, int income) {
        return (double) income / (double) (ticketCount * 1000);
    }

    private int aggregateIncome() {
        return Prize.FIRST.calculatePrize(this.countFirst) +
                Prize.SECOND.calculatePrize(this.countSecond) +
                Prize.THIRD.calculatePrize(this.countThird) +
                Prize.FOURTH.calculatePrize(this.countFourth) +
                Prize.FIFTH.calculatePrize(this.countFifth);
    }

    public int getIncome() {
        return income;
    }

    private int aggregate(Tickets challengerTickets, WinnerTicket winnerTicket, Prize prize) {
        return winnerTicket.countWinner(challengerTickets, prize);
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

    public double getProfitRatio() {
        return profitRatio;
    }

    public String breakEvenMessage() {
        return this.profitRatio >= 1 ? PROFIT_MESSAGE : LOSS_MESSAGE;
    }

    public int getCountSecond() {
        return this.countSecond;
    }
}
