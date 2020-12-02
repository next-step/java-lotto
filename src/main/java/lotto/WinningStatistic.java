package lotto;

public class WinningStatistic {

    private Statistics statistics;
    private final int purchaseAmount;

    public WinningStatistic (WinningCounts winningCounts, int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        calculateStatistics(winningCounts);
    }

    private void calculateStatistics(WinningCounts winningCounts) {
        Statistics initStatistics = new Statistics(new int[4]);
        for (int i = 0; i < winningCounts.size(); i++) {
            int winningCount = winningCounts.getWinningCount(i)
                    .getCount();

            statistics = initStatistics.calculateStatistics(winningCount);
        }
    }

    public int getStatisticsCount(int index) {
        return statistics.getStatisticsCount(index);
    }

    public double getRateOfReturn() {
        double winningAmount = 0;

        winningAmount += statistics.getStatisticsCount(0) * 5_000;
        winningAmount += statistics.getStatisticsCount(1) * 50_000;
        winningAmount += statistics.getStatisticsCount(2) * 1_500_000;
        winningAmount += statistics.getStatisticsCount(3) * 2_000_000_000;

        return Math.round((winningAmount / purchaseAmount) * 100) / 100.0;
    }
}
