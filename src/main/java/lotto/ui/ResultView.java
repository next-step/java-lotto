package lotto.ui;

import lotto.LottoNumber;
import lotto.LottoTicket;
import lotto.LottoWinnerClass;
import lotto.LottoWinnerStat;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_WINNER_STAT_BANNER = "당첨 통계\n---------";
    private static final String LOTTO_WINNER_STAT_FORMAT = "%d개 일치 - %d개\n";

    private ResultView() {

    }

    public static void printLottoTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            printLottoTicket(ticket);
        }
    }

    public static void printWinnerStat(LottoWinnerStat stat) {
        System.out.println(LOTTO_WINNER_STAT_BANNER);
        for (LottoWinnerClass winnerClass : LottoWinnerClass.values()) {
            printWinnerClass(stat, winnerClass);
        }
    }

    private static void printWinnerClass(LottoWinnerStat stat, LottoWinnerClass winnerClass) {
        System.out.printf(LOTTO_WINNER_STAT_FORMAT,
                winnerClass.getMatchingCount(),
                stat.getWinnerCount(winnerClass));
    }

    private static void printLottoTicket(LottoTicket ticket) {
        System.out.println(ticket.getNumbers().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList()));
    }
}
