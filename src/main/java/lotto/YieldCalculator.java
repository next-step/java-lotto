package lotto;

import java.util.Arrays;
import java.util.Map;

public class YieldCalculator {
    public static double calculateYield(Map<Rank, Long> result) {
        long totalWinningCount = result.values().stream()
                .mapToLong(Long::longValue)
                .sum();

        long totalWinningAmount = Arrays.stream(Rank.values())
                .mapToLong(rank -> calculateWinningAmountByRank(result, rank))
                .sum();

        return (double) totalWinningAmount / (totalWinningCount * Seller.PRICE) * 100;
    }

    private static long calculateWinningAmountByRank(Map<Rank, Long> result, Rank rank) {
        return result.getOrDefault(rank, 0L) * rank.getWinningMoney();
    }
}
