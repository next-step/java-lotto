package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoReport;
import lotto.model.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CHECK_PURCHASE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String SECOND_RANK_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
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
        List<Integer> numbers = ticket.numbers()
                .toList()
                .stream()
                .map(number -> number.number())
                .collect(Collectors.toList());
        System.out.println(numbers);
    }

    public static void printResultReport(LottoReport report) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 5; i > 0; i--) {
            LottoRank rank = LottoRank.getByRank(i);
            printResultRank(rank, report.countRank(rank));
        }
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, report.rateOfReturn()));
    }

    private static void printResultRank(LottoRank rank, int count) {
        if (rank.isSecondRank()) {
            System.out.println(String.format(SECOND_RANK_RESULT_MESSAGE, rank.matchCount(), rank.cashPrize(), count));
            return;
        }
        System.out.println(String.format(RANK_RESULT_MESSAGE, rank.matchCount(), rank.cashPrize(), count));
    }
}
