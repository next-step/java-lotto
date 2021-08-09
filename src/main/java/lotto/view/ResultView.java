package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.RANK;
import lotto.domain.WinningStatistics;

import java.util.Map;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계";
    private static final String WINNING_PRICE = "%d개 일치 (%d원)- ";
    private static final String WINNING_COUNT = "%d개";
    private static final String LINE = "-------";

    public void printLotties(Lotties lotties) {
        System.out.printf(PURCHASE_MESSAGE, lotties.getLottiesSize());
        for (Lotto lotto : lotties.getLotties()) {
            System.out.println(lotto.getLottoNumber().toString());
        }
        System.out.println();
    }

    public void printSameNumbers(WinningStatistics winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE);

        Map<RANK, Integer> statistics = winningStatistics.getWinningStatistics();

        for (RANK rank : RANK.values()) {
            System.out.printf(WINNING_PRICE, rank.getSameNumbersCount(), rank.getPrizeMoney());
            System.out.printf(WINNING_COUNT, statistics.get(rank));
            System.out.println();
        }

    }
}
