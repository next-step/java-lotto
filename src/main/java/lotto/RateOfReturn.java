package lotto;

public class RateOfReturn {

    public static double calculateRateOfReturn(WinningStatistic winningStatistic, int purchaseAmount) {
        double winningAmount = 0;

        winningAmount += winningStatistic.getStatisticsCount(0) * 5_000;
        winningAmount += winningStatistic.getStatisticsCount(1) * 50_000;
        winningAmount += winningStatistic.getStatisticsCount(2) * 1_500_000;
        winningAmount += winningStatistic.getStatisticsCount(3) * 2_000_000_000;

        return Math.round((winningAmount / purchaseAmount) * 100) / 100.0;
    }
}
