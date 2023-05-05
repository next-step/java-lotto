package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statics {
    private static final String PROFIT_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOSS_MESSAGE = "(손익분기점이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final Map<Prize, Integer> prizeIntegerMap;
    private final int totalTryTicketCount;

    public Statics(Tickets tickets, WinnerTicket winnerTicket) {
        totalTryTicketCount = tickets.count();
        prizeIntegerMap = aggregateBetter(tickets, winnerTicket);
    }

    private Map<Prize, Integer> aggregateBetter(Tickets tickets, WinnerTicket winnerTicket) {
        Map<Prize, Integer> prizeIntegerMap = new HashMap<>();
        for (Ticket ticket : tickets.allTickets()) {
            Prize prize = winnerTicket.checkLucky(ticket);
            prizeIntegerMap.put(prize, prizeIntegerMap.getOrDefault(prize, 0) + 1);
        }
        return prizeIntegerMap;
    }

    public int getIncome() {
        return Prize.FIRST.calculatePrize(this.countPrize(Prize.FIRST)) +
                Prize.SECOND.calculatePrize(this.countPrize(Prize.SECOND)) +
                Prize.THIRD.calculatePrize(this.countPrize(Prize.THIRD)) +
                Prize.FOURTH.calculatePrize(this.countPrize(Prize.FOURTH)) +
                Prize.FIFTH.calculatePrize(this.countPrize(Prize.FIFTH));
    }

    public int countPrize(Prize prize) {
        return this.prizeIntegerMap.getOrDefault(prize, 0);
    }

    public double profitRatio() {
        return (double) this.getIncome() / (double) (this.totalTryTicketCount * 1000);
    }

    public String breakEvenMessage() {
        return this.profitRatio() >= 1 ? PROFIT_MESSAGE : LOSS_MESSAGE;
    }
}
