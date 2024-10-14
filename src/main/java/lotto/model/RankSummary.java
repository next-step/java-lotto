package lotto.model;

import java.util.Map;
import lotto.domain.Rank;

public class RankSummary {
    private final Map<Rank, Long> rankCounts;
    private final double profitRate;

    public RankSummary(Map<Rank, Long> rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.profitRate = profitRate;
    }

    public Map<Rank, Long> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
