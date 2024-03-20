package lotto.domain;

import java.util.List;

public class Statistics {

    private List<Statistic> statistics;
    private Budget budget;

    public Statistics(List<Statistic> statistics, Budget budget) {
        this.statistics = statistics;
        this.budget = budget;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public float getRateOfReturn() {
        return getTotalReturn() / budget.getValue();
    }

    private int getTotalReturn() {
        return statistics.stream().mapToInt(Statistic::getPrice).sum();
    }
}
