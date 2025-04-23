package lotto.domain;

import java.util.*;

public class ResultStats {
    private final Map<Rank, Integer> stats;
    private final int totalPrize;

    public ResultStats(Map<Rank, Integer> stats, int totalPrize) {
        this.stats = Collections.unmodifiableMap(new EnumMap<>(stats));
        this.totalPrize = totalPrize;
    }

    public Map<Rank, Integer> getStats() {
        return stats;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public double calculateProfitRate(int totalSpent) {
        return totalPrize / (double) totalSpent;
    }

    public int getCountByRank(Rank rank) {
        return stats.getOrDefault(rank, 0);
    }
}

