package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.RankingResult;

import java.util.Collections;

public class ResultView {
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String RANKING_RESULT_MESSAGE = "%s - %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private ResultView() {
    }

    public static void printPurchaseMessage(Lottos lottos, int purchaseCount) {
        System.out.printf((PURCHASE_RESULT_MESSAGE) + "%n", purchaseCount);
        System.out.println(lottos.toString());
    }

    public static void printWinningMessage(RankingResult rankingResult, double yield) {
        System.out.println(WINNING_RESULT_MESSAGE);
        rankingResult.getWinningLottoMap().keySet()
                .stream()
                .sorted(Collections.reverseOrder())
                .forEach(ranking -> System.out.printf((RANKING_RESULT_MESSAGE) + "%n", ranking.toString(), rankingResult.findRankingCount(ranking)));

        System.out.printf((TOTAL_YIELD_MESSAGE) + "%n", yield);
    }
}
