package lotto.domain.result;

import java.util.Map;

public class LottoStatistics {

    private final Map<Rank, Integer> results;
    private final double profitRatio;

    private LottoStatistics(Map<Rank, Integer> results, double profitRatio) {
        this.results = results;
        this.profitRatio = profitRatio;
    }

    public static LottoStatistics of(Map<Rank, Integer> results, double profitRatio) {
        return new LottoStatistics(results, profitRatio);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

}
