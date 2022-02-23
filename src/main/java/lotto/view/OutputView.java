package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public class OutputView {

    private static final String PURCHASE_AMOUNT_MANAGER_LOG = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String WINNING_RESULT_HEAD_LOG = "\n당첨통계\n---------";
    private static final String MATCH_COUNT_LOG = "%d개 일치 (%d원)- %d개";
    private static final String MATCH_BONUS_LOG = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_LOG = "총 수익률은 %.1f입니다.";

    public static void printPurchaseInfo(int manualCount, int autoCount, List<String> lottos) {
        System.out.println();
        printPurchaseAmount(manualCount, autoCount);
        printPurchaseTicket(lottos);
    }
    private static void printPurchaseAmount(int manualCount, int autoCount) {
        System.out.printf((PURCHASE_AMOUNT_MANAGER_LOG) + "%n", manualCount, autoCount);
    }

    private static void printPurchaseTicket(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Rank, Integer> result, BigDecimal profitRate) {
        System.out.println(WINNING_RESULT_HEAD_LOG);
        printMatchCount(result);
        printProfitRate(profitRate);
    }

    private static void printMatchCount(Map<Rank, Integer> result) {
        for (Rank rank : result.keySet()) {
            printCountByRank(rank, result.get(rank));
        }
    }

    private static void printCountByRank(Rank rank, int count) {
        int matchCount = rank.getMatchCount();
        long prizeMoney = rank.getPrizeMoney();

        if (rank == Rank.SECOND) {
            System.out.printf((MATCH_BONUS_LOG) + "%n", matchCount, prizeMoney, count);
            return;
        }
        System.out.printf((MATCH_COUNT_LOG) + "%n", matchCount, prizeMoney, count);
    }

    private static void printProfitRate(BigDecimal profitRate) {
        System.out.printf((PROFIT_RATE_LOG) + "%n", profitRate);
    }
}
