package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d장를 구매했습니다.\n\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계";
    private static final String LINE = "-------";

    private static final String MATCH_COUNT_3 = "3개 일치 (5000원)- %d개\n";
    private static final String MATCH_COUNT_4 = "4개 일치 (50000원)- %d개\n";
    private static final String MATCH_COUNT_5 = "5개 일치 (1500000원)- %d개\n";
    private static final String MATCH_COUNT_5_BONUS = "5개 일치, 보너스 볼 일치(30000000원)- %d개\n";
    private static final String MATCH_COUNT_6 = "6개 일치 (2000000000원)- %d개\n";

    public void printLottos(Lottos lottos, int autoCount) {
        System.out.printf(PURCHASE_MESSAGE, lottos.size() - autoCount, autoCount);
        for (Lotto lotto : lottos.getLottos()) {

            System.out.print(lotto.getLottoNumbers().stream()
                    .map(number -> String.valueOf(number))
                    .collect(Collectors.joining(", ", "[", "]")));

            System.out.println();
        }
    }

    public void printSameNumbers(WinningStatistics winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE);

        System.out.printf(MATCH_COUNT_3, winningStatistics.getRankCount(Rank.FOURTH));
        System.out.printf(MATCH_COUNT_4, winningStatistics.getRankCount(Rank.THIRD));
        System.out.printf(MATCH_COUNT_5, winningStatistics.getRankCount(Rank.SECOND));
        System.out.printf(MATCH_COUNT_5_BONUS, winningStatistics.getRankCount(Rank.SECOND));
        System.out.printf(MATCH_COUNT_6, winningStatistics.getRankCount(Rank.FIRST));
        System.out.println();
    }

}
