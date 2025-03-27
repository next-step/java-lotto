package step2;

import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> statistics;
    private final double profitRate;

    public LottoStatistics(Map<LottoResult, Integer> statistics, double profitRate) {
        this.statistics = statistics;
        this.profitRate = profitRate;
    }

    public Map<LottoResult, Integer> getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
