package lotto.util;

import java.util.Map;

public class RateCalculator {
    public static double calculateProfitRate(Map<Integer, Integer> winningMap, int totalPrice) {
        long totalWinningAmount = 0;
        totalWinningAmount += winningMap.getOrDefault(3, 0) * 5000L;
        totalWinningAmount += winningMap.getOrDefault(4, 0) * 50000L;
        totalWinningAmount += winningMap.getOrDefault(5, 0) * 1500000L;
        totalWinningAmount += winningMap.getOrDefault(6, 0) * 2000000000L;

        return (double) totalWinningAmount / totalPrice;
    }
}
