package lotto.domain;

import java.util.Map;

public class Revenue {
    Long value;

    public Revenue(Map<WinningType, Long> winningStatistic) {
        this.value = winningStatistic.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getRevenue() * entry.getValue())
                .reduce(0, Long::sum);
    }

    public double returnRate(int amount) {
        return Double.valueOf(this.value) / amount;
    }
}
