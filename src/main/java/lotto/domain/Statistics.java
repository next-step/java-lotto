package lotto.domain;

import java.util.List;

public class Statistics {

    private List<Statistic> statistics;

    public Statistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public float getRateOfReturn() {
        return (float) getTotalReturn() / (statistics.size() * Lotto.LOTTO_PRICE);
    }

    private int getTotalReturn() {
        return statistics.stream()
                .filter(Statistic::isValid)
                .mapToInt(Statistic::getPrice)
                .sum();
    }

    public int getMatchCount(Statistic matcher) {
        return (int) statistics.stream().filter(statistic -> statistic == matcher).count();
    }
}
