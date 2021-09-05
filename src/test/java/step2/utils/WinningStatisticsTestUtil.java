package step2.utils;

import step2.domain.statistics.WinningStatistics;
import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinningStatisticsTestUtil {
    public static WinningStatistics createTestWinningStatistics(int matchCount, int amount) {
        final long profitValue = createTestProfitValue(matchCount, amount);

        return new WinningStatistics(createTestMatchValue(matchCount, amount),
                profitValue,
                createTestProfitRateValue(profitValue, amount),
                amount);
    }

    private static double createTestProfitRateValue(long profitValue, int amount) {
        return profitValue / (double) (amount * 1000);
    }

    private static Map<Rank, Integer> createTestMatchValue(int matchCount, int amount) {
        Map<Rank, Integer> match = new HashMap<>();
        match.put(Rank.FIFTH, 0);
        match.put(Rank.FOURTH, 0);
        match.put(Rank.THIRD, 0);
        match.put(Rank.FIRST, 0);

        final Rank target = Rank.createRank(matchCount);
        match.put(target, amount);
        return match;
    }

    private static long createTestProfitValue(int matchCount, int amount) {
        final Rank rank = Rank.createRank(matchCount);
        return rank.winnings * amount;
    }
}
