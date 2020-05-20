package lotto.domain.view;

import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.ticket.LottoTicket;

import java.util.List;

public class ResultView {

    private final static String TICKET_PURCHASE_CONFIRM_MESSAGE = "%d개를 구입했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%% 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchasedTicketCount(final int count) {
        System.out.println(String.format(TICKET_PURCHASE_CONFIRM_MESSAGE, count));
    }

    public static void printTickets(final List<LottoTicket> tickets) {
        tickets.forEach(ticket -> System.out.println(ticket.toString()));
        System.out.println();
    }

    public static void printStatisticsResult(final LottoPrizeResult result) {
        System.out.println(RESULT);
        System.out.println(result.toString());
    }

    public static void printProfitRate(final float profitRate) {
        System.out.println(String.format(PROFIT_RATE_FORMAT, profitRate));
    }
}
