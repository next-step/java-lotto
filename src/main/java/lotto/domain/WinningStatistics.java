package lotto.domain;

import java.util.Map;

public class WinningStatistics {
    private Map<Rank, Long> statistics;

    public WinningStatistics(Map<Rank, Long> statistics) {
        this.statistics = statistics;
    }

    public Map<Rank, Long> getStatistics() {
        return statistics;
    }

    public double yield() {
        double yield = purchaseAmount() / total();

        if (Double.isInfinite(yield)) {
            return 0;
        }
        return yield;
    }

    private double purchaseAmount() {
        return statistics.size() * 1000;
    }

    private double total() {
        long total = 0L;
        for (Rank rank : Rank.values()) {
            total += rank.getMoney() * statistics.getOrDefault(rank, 0L);
        }

        return total;
    }
}
