package com.game.lotto.rate;

import com.game.lotto.prize.PrizeByStrikesEnum;
import com.game.lotto.ticket.Ticket;
import com.game.lotto.ticket.MyTickets;
import com.game.lotto.ui.ResultView;

import java.util.List;

import static com.game.lotto.ui.ResultView.*;

public class EarningRates {
    private final long totalAmountOfTicketMoney;
    private long totalAmountOfPrizeMoney;
    private final MyTickets myTickets;

    public EarningRates(long totalAmountOfTicketMoney, MyTickets myTickets) {
        this.totalAmountOfTicketMoney = totalAmountOfTicketMoney;
        this.totalAmountOfPrizeMoney = 0;
        this.myTickets = myTickets;
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
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.FOURTH_PRIZE_MONEY_AMOUNT_WITH_3_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.THIRD_PRIZE_MONEY_AMOUNT_WITH_4_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES);
        totalAmountOfPrizeMoney += getTotalAmountOfPrizeMoney(PrizeByStrikesEnum.FIRST_PRIZE_MONEY_AMOUNT_WITH_6_STRIKES);
    }

    private long getTotalAmountOfPrizeMoney(PrizeByStrikesEnum prizeByStrikesEnum) {
        List<Ticket> ticketsByStrikes = myTickets.getTicketsByStrikes(prizeByStrikesEnum.getStrikes());
        int ticketsByStrikesSize = ticketsByStrikes.size();
        ResultView.printStrikesAndSize(prizeByStrikesEnum, ticketsByStrikesSize);
        return ticketsByStrikesSize * prizeByStrikesEnum.getMoneyAmount();
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
