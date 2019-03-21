package lotto.application;

public class ResultView {
    private final WinningStatisticsView statistics;
    private final double roi;

    public ResultView(final WinningStatisticsView statistics, final double roi) {
        this.statistics = statistics;
        this.roi = roi;
    }

    public WinningStatisticsView getStatistics() {
        return statistics;
    }

    public double getRoi() {
        return roi;
    }
}
