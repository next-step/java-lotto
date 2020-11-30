package lotto;

import java.util.List;

public class RateOfReturn {

    public static double calculateRateOfReturn(WinningStatistic winningStatistic, int purchaseAmount) {
        double winningAmount = 0;

        winningAmount += winningStatistic.getStatistics(0) * 5_000;
        winningAmount += winningStatistic.getStatistics(1) * 50_000;
        winningAmount += winningStatistic.getStatistics(2) * 1_500_000;
        winningAmount += winningStatistic.getStatistics(3) * 2_000_000_000;

        return Math.round((winningAmount / purchaseAmount) * 100) / 100.0;
    }
}
