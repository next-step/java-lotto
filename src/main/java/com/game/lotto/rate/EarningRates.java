package com.game.lotto.rate;

import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.MyTicket;
import com.game.lotto.ticket.TicketsByRanks;
import com.game.lotto.ui.ResultView;

import java.util.Arrays;
import java.util.List;

import static com.game.lotto.ui.ResultView.*;

public class EarningRates {
    private final long totalAmountOfTicketMoney;
    private long totalAmountOfPrizeMoney;
    private final TicketsByRanks ticketsByRanks;

    public EarningRates(long totalAmountOfTicketMoney, TicketsByRanks ticketsByRanks) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.totalAmountOfPrizeMoney = 0;
        this.ticketsByRanks = ticketsByRanks;
    }

    public double calculateEarningRatesAndPrintResults() {
        double earningRates = calculateEarningRates();
        printGameResult(earningRates);
        return earningRates;
    }

    private double calculateEarningRates() {
        calculateTotalPrize();
        return (double) totalAmountOfPrizeMoney / totalAmountOfTicketMoney;
    }

    private void calculateTotalPrize() {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(rank));
    }

    private long getTotalAmountOfPrizeMoney(Rank rank) {
        List<MyTicket> ticketsByRanks = this.ticketsByRanks.getTicketsByRank(rank);
        int ticketsByRanksSize = ticketsByRanks.size();
        ResultView.printStrikesAndSize(rank, ticketsByRanksSize);
        return ticketsByRanksSize * rank.getMoneyAmount();
    }

    private void printGameResult(double earningRates) {
        if (earningRates > 1) {
            ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_HIGH_MESSAGE);
            return;
        }
        if (earningRates == 1) {
            ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_EQUAL_MESSAGE);
            return;
        }
        ResultView.printEarningRatesAndMessage(earningRates, OUTPUT_RESULT_EARNING_RATE_LOW_MESSAGE);
    }
}
