package com.game.lotto.ui;

import com.game.lotto.count.TicketCount;
import com.game.lotto.prize.Rank;
import com.game.lotto.ticket.MyTicket;

public class ResultView {
    private static final String OUTPUT_COUNT_MESSAGE_FORMAT = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String OUTPUT_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String OUTPUT_RESULT_STRIKES_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_RESULT_STRIKES_AND_BONUS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String OUTPUT_RESULT_EARNING_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    public static final String OUTPUT_RESULT_EARNING_RATE_LOW_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String OUTPUT_RESULT_EARNING_RATE_EQUAL_MESSAGE = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    public static final String OUTPUT_RESULT_EARNING_RATE_HIGH_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public static void printOutputCountMessage(TicketCount totalCount, TicketCount manualCount) {
        int totalCounts = totalCount.getCount();
        int manualCounts = manualCount.getCount();
        int randomCounts = totalCounts - manualCounts;
        System.out.printf(OUTPUT_COUNT_MESSAGE_FORMAT, manualCounts, randomCounts);
    }

    public static void printResultMessage() {
        printMessage(OUTPUT_RESULT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printTicketNumbers(MyTicket myTicket) {
        System.out.println(myTicket);
    }

    public static void printStrikesAndSize(Rank rank, int ticketsByRanksSize) {
        String format = OUTPUT_RESULT_STRIKES_MESSAGE_FORMAT;
        if (Rank.SECOND_PRIZE_MONEY_AMOUNT_WITH_5_STRIKES_AND_BONUS.equals(rank)) {
            format = OUTPUT_RESULT_STRIKES_AND_BONUS_MESSAGE_FORMAT;
        }
        System.out.printf((format) + "%n", rank.getStrikes().getCount(), rank.getMoneyAmount().getAmount(), ticketsByRanksSize);
    }

    public static void printGameResult(double earningRates) {
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

    private static void printEarningRatesAndMessage(double earningRates, String message) {
        System.out.printf(OUTPUT_RESULT_EARNING_RATE_MESSAGE_FORMAT, earningRates);
        System.out.println(message);
    }
}
