package step2.domain.statistics;

import java.util.Objects;

public class Statistics {
    private final WinningStatistics winningStatistics;
    private final Match match;

    public Statistics(WinningStatistics winningStatistics, Match match) {
        this.winningStatistics = winningStatistics;
        this.match = match;
    }

    public ProfitRate profitRate() {
        return this.winningStatistics.profitRate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics)) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(winningStatistics, that.winningStatistics) && Objects.equals(match, that.match);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningStatistics, match);
    }
}
