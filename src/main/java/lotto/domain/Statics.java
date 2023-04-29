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

    public Statics(List<UserTicket> userTickets, WinnerTicket winnerTicket) {
        this.countFirst = aggregate(userTickets, winnerTicket.ticketOnly(), Prize.FIRST);
        this.countSecond = aggregate(userTickets, winnerTicket, Prize.SECOND);
        this.countThird = aggregate(userTickets, winnerTicket, Prize.THIRD);
        this.countFourth = aggregate(userTickets, winnerTicket.ticketOnly(), Prize.FOURTH);
        this.countFifth = aggregate(userTickets, winnerTicket.ticketOnly(), Prize.FIFTH);
        this.income = aggregateIncome();
        this.profitRatio = aggregateProfitRatio(userTickets.size(), this.income);
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

    private int aggregate(List<UserTicket> challengerUserTickets, WinnerTicket winnerTicket, Prize prize) {
        return winnerTicket.countWinner(challengerUserTickets, prize);
    }

    private int aggregate(List<UserTicket> challengerUserTickets, UserTicket winnerUserTicket, Prize prize) {
        return winnerUserTicket.countWinner(challengerUserTickets, prize);
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
