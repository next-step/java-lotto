package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoStatistics {
    private Map<LottoResult, Integer> resultCountMap = new HashMap<>();
    private Money spend;

    public LottoStatistics(LottoResults results, Money spend) {
        this.spend = spend;

        for (LottoResult result : results) {
            resultCountMap.compute(result, (key, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
        }
    }

    public Integer count(LottoResult result) {
        return resultCountMap.getOrDefault(result, 0);
    }

    public double calculateProfitRate() {
        Money totalProfit = getTotalProfit();

        return totalProfit.divide(spend);
    }

    private Money getTotalProfit() {
        return resultCountMap.entrySet().stream()
            .map(entry -> entry.getKey().getWinningPrice().multiply(entry.getValue()))
            .reduce(new Money(0), Money::add);
    }
}
