package step2.domain.statistics;

import java.util.Objects;

public class Statistics {
    private final Profit profit;
    private final Match match;

    public Statistics(Profit profit, Match match) {
        this.profit = profit;
        this.match = match;
    }

    public ProfitRate profitRate() {
        return this.profit.profitRate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistics)) return false;
        Statistics that = (Statistics) o;
        return Objects.equals(profit, that.profit) && Objects.equals(match, that.match);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profit, match);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(this.match)
                .toString();
    }

}
