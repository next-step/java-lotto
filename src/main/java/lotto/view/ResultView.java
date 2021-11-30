package lotto.view;


import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.winning.WinningLottoStats;
import lotto.domain.winning.WinningPolicy;

import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printView(String str) {
        System.out.println(str);
    }

    public static void printLottoNumberView(Lottos lottos) {
        lottos.getLottos().forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printWinningStatsView(WinningLottoStats stats) {
        Map<Integer, Integer> winningStatsMap = stats.getWinningStatsMap();

        for (Map.Entry<Integer, Integer> entry : winningStatsMap.entrySet()) {
            int matchingCount = entry.getKey();
            int winningCount = entry.getValue();
            int winningAmount = WinningPolicy.MATCHING_WINNINGAMOUNT_MAP.get(matchingCount);

            String str = String.format("%d개 일치 (%d원)- %d개", matchingCount, winningAmount, winningCount);
            System.out.println(str);
        }
    }
}
