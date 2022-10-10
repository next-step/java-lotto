package com.game.lotto.rate;

import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.TicketsByStrikes;
import com.game.lotto.ui.ResultView;

import java.util.List;

import static com.game.lotto.ui.ResultView.*;

public class EarningRates {
    private final long totalAmountOfTicketMoney;
    private long totalAmountOfPrizeMoney;
    private final TicketsByStrikes ticketsByStrikes;

    public EarningRates(long totalAmountOfTicketMoney, TicketsByStrikes ticketsByStrikes) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.totalAmountOfPrizeMoney = 0;
        this.ticketsByStrikes = ticketsByStrikes;
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
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(Rank.FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES);
    }

    private long getTotalAmountOfPrizeMoney(Rank rank) {
        List<Ticket> ticketsByStrikes = this.ticketsByStrikes.getTicketsByStrikes(rank.getStrikes());
        int ticketsByStrikesSize = ticketsByStrikes.size();
        ResultView.printStrikesAndSize(rank, ticketsByStrikesSize);
        return ticketsByStrikesSize * rank.getMoneyAmount();
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
