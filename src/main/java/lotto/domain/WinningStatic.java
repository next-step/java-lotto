package lotto.domain;

import java.util.Map;

public class WinningStatic {
    private Map<WinningType, Long> winningStatistic;

    public WinningStatic(Map<WinningType, Long> winningStatistic) {
        this.winningStatistic = winningStatistic;
    }

    public Long countWinnersByWinningType(WinningType type) {
        return winningStatistic.getOrDefault(type, 0L);
    }

    public double returnRate(int amount) {
        Long revenue = this.winningStatistic.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getRevenue() * entry.getValue())
                .reduce(0, Long::sum);
        return Double.valueOf(revenue) / amount;
    }
}
