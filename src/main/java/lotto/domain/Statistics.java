package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Statistics {

    private List<Statistic> statistics;

    public Statistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public float getRateOfReturn(int lottoPrice) {
        return (float) getTotalReturn() / getBudgetBy(lottoPrice);
    }

    private int getTotalReturn() {
        return statistics.stream()
            .filter(Statistic::isValidMatcher)
            .mapToInt(Statistic::getPrice)
            .sum();
    }

    private int getBudgetBy(int price) {
        return getSize() * price;
    }

    public int getMatchCount(Statistic matcher) {
        return (int) statistics.stream().filter(statistic -> statistic == matcher).count();
    }

    private int getSize() {
        return statistics.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statistics that = (Statistics) o;
        return Objects.equals(statistics, that.statistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statistics);
    }
}
