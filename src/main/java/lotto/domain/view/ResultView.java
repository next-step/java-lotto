package lotto.domain.view;

import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.ticket.LottoTicket;

import java.util.List;

public class ResultView {

    private final static String TICKET_PURCHASE_CONFIRM_MESSAGE = "%d개를 구입했습니다.";
    private final static String RESULT = "\n당첨 통계\n--------";

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
}
