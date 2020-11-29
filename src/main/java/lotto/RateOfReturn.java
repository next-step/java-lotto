package lotto;

import java.util.List;

public class RateOfReturn {

    public static double calculateRateOfReturn(List<Integer> winningCounts, int purchaseAmount) {
        double winningAmount = 0;

        winningAmount += winningCounts.get(0) * 5_000;
        winningAmount += winningCounts.get(1) * 50_000;
        winningAmount += winningCounts.get(2) * 1_500_000;
        winningAmount += winningCounts.get(3) * 2_000_000_000;

        return Math.round((winningAmount / purchaseAmount) * 100) / 100.0;
    }
}
