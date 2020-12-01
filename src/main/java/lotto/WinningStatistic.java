package lotto;

public class WinningStatistic {

    private Statistics statistics;

    public WinningStatistic (WinningCounts winningCounts) {
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
}
