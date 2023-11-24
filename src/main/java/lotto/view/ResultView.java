package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoReport;
import lotto.model.Lottos;

public class ResultView {
    private static final String CHECK_PURCHASE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String COLLECT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다.";

    public static void printCheckPurchaseMessage(int purchaseAmount) {
        System.out.println(String.valueOf(purchaseAmount) + CHECK_PURCHASE);
    }

    public static void printLottoTickets(Lottos tickets) {
        for (Lotto ticket : tickets.tickets()) {
            printLottoTicket(ticket);
        }
    }

    private static void printLottoTicket(Lotto ticket) {
        System.out.println(ticket.numbers());
    }

    public static void printResultReport(LottoReport report) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 3; i < 7; i++) {
            System.out.println(String.format(COLLECT_MESSAGE, i, LottoRank.valueOf(i, false).cashPrize(), report.result().get(i)));
        }
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, report.rateOfReturn()));
    }
}
