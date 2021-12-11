package step2.domain;

import step2.domain.enums.RANKING;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Statistics {
    final double profitAmount;
    static Map<RANKING, Integer> statistics;

    public Statistics(Lotteries lotteries, Lottery winningNumbers) {
        statistics = new LinkedHashMap() {{
            for (RANKING rank : RANKING.values()) {
                put(rank, 0);
            }
        }};

        for (Lottery lottery : lotteries.getList()) {
            setStatistics(lottery, winningNumbers);
        }

        this.profitAmount = calculateProfitAmount();
    }

    private void setStatistics(Lottery lottery, Lottery winningNumbers) {
        int count = lottery.correctCount(winningNumbers);
        RANKING key = RANKING.of(count);

        if (statistics.containsKey(key)) {
            statistics.put(key, statistics.get(key) + 1);
        }
    }

    public Map<RANKING, Integer> getStatistics() {
        return statistics;
    }

    public double calculateProfitRate(double purchaseAmount) {
        return Math.floor(this.profitAmount / purchaseAmount * 100) / 100;
    }

    private int calculateProfitAmount() {
        int money = 0;

        for (Map.Entry<RANKING, Integer> entry : this.statistics.entrySet()) {
            money += entry.getKey().getPrizeMoney() * entry.getValue();
        }

        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Double.compare(that.profitAmount, profitAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitAmount);
    }
}
