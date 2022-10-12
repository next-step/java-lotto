package com.game.lotto.rate;

import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.MyTicket;
import com.game.lotto.ticket.TicketsByRanks;
import com.game.lotto.ui.ResultView;

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
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.THIRD_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.FOURTH_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.FIFTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES);
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
