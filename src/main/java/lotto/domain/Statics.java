package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statics {
    private static final String PROFIT_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOSS_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Map<Prize, Integer> prizeIntegerMap;
    private final int totalTryTicketCount;
    //private final int income;
    //private final double profitRatio;

    public Statics(Tickets tickets, WinnerTicket winnerTicket) {
        totalTryTicketCount = tickets.count();
        prizeIntegerMap = aggregateBetter(tickets, winnerTicket);
//        this.countFirst = aggregate(tickets, winnerTicket, Prize.FIRST);
//        this.countSecond = aggregate(tickets, winnerTicket, Prize.SECOND);
//        this.countThird = aggregate(tickets, winnerTicket, Prize.THIRD);
//        this.countFourth = aggregate(tickets, winnerTicket, Prize.FOURTH);
//        this.countFifth = aggregate(tickets, winnerTicket, Prize.FIFTH);
        //this.income = aggregateIncome();
        //this.profitRatio = aggregateProfitRatio(tickets.count(), this.income);
    }

    private Map<Prize, Integer> aggregateBetter(Tickets tickets, WinnerTicket winnerTicket) {
        Map<Prize, Integer> prizeIntegerMap = new HashMap<>();
        for( Ticket ticket : tickets.getTickets()) {
            Prize prize = winnerTicket.checkLucky(ticket);
            prizeIntegerMap.put(prize, prizeIntegerMap.getOrDefault(prize, 0) + 1);
        }
        return prizeIntegerMap;
    }

    private double aggregateProfitRatio(int ticketCount, int income) {
        return (double) income / (double) (ticketCount * 1000);
    }

    public int getIncome() {
        return Prize.FIRST.calculatePrize(prizeIntegerMap.get(Prize.FIRST)) +
                Prize.SECOND.calculatePrize(prizeIntegerMap.get(Prize.SECOND)) +
                Prize.THIRD.calculatePrize(prizeIntegerMap.get(Prize.THIRD)) +
                Prize.FOURTH.calculatePrize(prizeIntegerMap.get(Prize.FOURTH)) +
                Prize.FIFTH.calculatePrize(prizeIntegerMap.get(Prize.FIFTH));
    }

//    private int aggregate(Tickets challengerTickets, WinnerTicket winnerTicket, Prize prize) {
//        return winnerTicket.countWinner(challengerTickets, prize);
//    }

    public int countPrize(Prize prize) {
        return this.prizeIntegerMap.get(prize);
    }

    public double profitRatio() {
        return aggregateProfitRatio(this.totalTryTicketCount, this.getIncome());
    }

    public String breakEvenMessage() {
        return this.profitRatio() >= 1 ? PROFIT_MESSAGE : LOSS_MESSAGE;
    }
}
