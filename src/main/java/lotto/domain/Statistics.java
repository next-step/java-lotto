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
}
