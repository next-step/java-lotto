package com.game.lotto.ui;

import com.game.lotto.prize.PrizeByStrikesEnum;
import com.game.lotto.ticket.Ticket;

public class ResultView {
    private static final String OUTPUT_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String OUTPUT_RESULT_STRIKES_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_RESULT_EARNING_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    public static final String OUTPUT_RESULT_EARNING_RATE_LOW_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String OUTPUT_RESULT_EARNING_RATE_EQUAL_MESSAGE = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    public static final String OUTPUT_RESULT_EARNING_RATE_HIGH_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public static void printOutputCountMessage(long count) {
        printMessage(count + OUTPUT_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        printMessage(OUTPUT_RESULT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printTicketNumbers(Ticket ticket) {
        System.out.println(ticket.getNumbers());
    }

    public static void printStrikesAndSize(PrizeByStrikesEnum prizeByStrikesEnum, int ticketsByStrikesSize) {
        System.out.printf((OUTPUT_RESULT_STRIKES_MESSAGE_FORMAT) + "%n", prizeByStrikesEnum.getStrikes(), prizeByStrikesEnum.getMoneyAmount(), ticketsByStrikesSize);
    }

    public static void printEarningRatesAndMessage(double earningRates, String message) {
        System.out.printf(OUTPUT_RESULT_EARNING_RATE_MESSAGE_FORMAT, earningRates);
        System.out.println(message);
    }
}
