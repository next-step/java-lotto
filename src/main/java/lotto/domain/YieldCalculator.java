package lotto.domain;

import java.util.List;

public class YieldCalculator {
    public static double calculate(long cost, List<RankResult> rankResults) {
        long sum = 0L;
        for (RankResult rankResult : rankResults) {
            Rank rank = rankResult.getRank();
            long rankCnt = rankResult.getRankCnt();
            sum += rank.calculateTotalPrizePerRank(rankCnt);
        }

        double yield = (double) sum / cost;
        return createFormattedYield(yield);
    }

    private static double createFormattedYield(double yield) {
        return Math.floor(yield * 100.0) / 100.0;
    }
}
