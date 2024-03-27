package lotto.domain;

import java.util.Map;

public class WinningResult {

    private final Map<Integer, Integer> winningCounts;
    private final int totalPrice;

    public WinningResult(Map<Integer, Integer> winningCounts, int totalPrice) {
        this.winningCounts = winningCounts;
        this.totalPrice = totalPrice;
    }

    public Map<Integer, Integer> getWinningCounts() {
        return winningCounts;
    }

    public double profitRate() {
        long totalWinningAmount = 0;
        totalWinningAmount += winningCounts.getOrDefault(3, 0) * 5000L;
        totalWinningAmount += winningCounts.getOrDefault(4, 0) * 50000L;
        totalWinningAmount += winningCounts.getOrDefault(5, 0) * 1500000L;
        totalWinningAmount += winningCounts.getOrDefault(6, 0) * 2000000000L;

        return (double) totalWinningAmount / totalPrice;
    }
}
