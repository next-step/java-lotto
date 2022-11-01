package lotto.ui;

import lotto.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_WINNER_STAT_BANNER = "당첨 통계\n---------";
    private static final String LOTTO_WINNER_STAT_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String PROFIT_MARGIN_FORMAT = "총 수익률은 %.2f 입니다.\n";
    private static final List<LottoResult> PRINTABLE_LOTTO_RESULT = List.of(
            LottoResult.FOURTH, LottoResult.THIRD, LottoResult.SECOND, LottoResult.FIRST);

    private ResultView() {

    }

    public static void printLottoTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            printLottoTicket(ticket);
        }
    }

    public static void printLottoResults(LottoResultStat stat) {
        System.out.println(LOTTO_WINNER_STAT_BANNER);
        for (LottoResult result : PRINTABLE_LOTTO_RESULT) {
            printLottoResult(stat, result);
        }
    }

    private static void printLottoResult(LottoResultStat stat, LottoResult result) {
        System.out.printf(LOTTO_WINNER_STAT_FORMAT,
                result.getMatchingCount(), result.getPrize(), stat.getWinnerCount(result));
    }

    private static void printLottoTicket(LottoTicket ticket) {
        System.out.println(ticket.getNumbers().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList()));
    }

    public static void printProfitMargin(double profitMargin) {
        System.out.printf(PROFIT_MARGIN_FORMAT, profitMargin);
    }
}
