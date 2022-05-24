package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;

import java.util.Collections;

import static lotto.domain.Ranking.MISS;

public class ResultView {
    private static final String PURCHASE_RESULT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---------";
    private static final String RANKING_RESULT_MESSAGE = "%s - %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.%s";
    private static final String MINUS_PROFIT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String ZERO_PROFIT = "(기준이 0때문에 결과적으로 본전이라는 의미임)";
    private static final String PLUS_PROFIT = "(기준이 1이상이기 때문에 결과적으로 이득이라는 의미임)";

    private ResultView() {
    }

    public static void printPurchaseMessage(Lottos lottos, int manualCount, int randomCount) {
        System.out.printf((PURCHASE_RESULT_MESSAGE) + "%n", manualCount, randomCount);
        System.out.println(lottos.toString());
    }

    public static void printWinningMessage(RankingResult rankingResult, double yield) {
        System.out.println(WINNING_RESULT_MESSAGE);
        rankingResult.getWinningLottoMap().keySet()
                .stream()
                .sorted(Collections.reverseOrder())
                .filter(ranking -> ranking != MISS)
                .forEach(ranking -> System.out.printf((RANKING_RESULT_MESSAGE) + "%n", ranking.toString(), rankingResult.findRankingCount(ranking)));

        System.out.printf((TOTAL_YIELD_MESSAGE) + "%n", yield, findMessageFromProfit(yield));
    }

    private static String findMessageFromProfit(double yield) {
        if (yield > 1) {
            return PLUS_PROFIT;
        }
        if (yield < 1) {
            return MINUS_PROFIT;
        }
        return ZERO_PROFIT;
    }
}
