package utils;

import domain.Lotto;
import domain.LottoStatistics;
import domain.Rank;

import java.util.List;

public class OutputView {
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계";
    private static final String HYPHEN = "-";
    private static final String UNIT = "개";
    private static final String BUY_MESSAGE = "개를 구매했습니다.";

    public static void printStatistics(LottoStatistics statistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(HYPHEN.repeat(9));

        for (Rank rank : List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
            System.out.println(rank.getMessage() + HYPHEN + " " + statistics.getCountByRank(rank) + UNIT);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.\n", profitRate);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + BUY_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}