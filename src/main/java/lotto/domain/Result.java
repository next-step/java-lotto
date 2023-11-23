package lotto.domain;

import lotto.enums.Rank;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private final Tickets tickets;
    private final Numbers winningNumbers;

    public Result(Tickets tickets, Numbers winningNumbers) {
        this.tickets = tickets;
        this.winningNumbers = winningNumbers;
    }

    public long calcWinningAmount() {
        long totalAmount = 0;
        EnumMap<Rank, Integer> countPerPrize = tickets.makeStatistics(winningNumbers);
        for (Map.Entry<Rank, Integer> entry : countPerPrize.entrySet()) {
            totalAmount += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        return totalAmount;
    }


    public double calcRateOfReturn() {
        return (double) this.calcWinningAmount() / (this.tickets.ticketCount() * 1000L);
    }
}
