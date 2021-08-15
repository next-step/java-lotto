package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoStatistics {
    private final Map<LottoPlace, Integer> resultCountMap = new HashMap<>();
    private final Money spend;

    public LottoStatistics(LottoResults results, Money spend) {
        this.spend = spend;

        for (LottoPlace result : results) {
            resultCountMap.compute(result, (key, oldValue) -> Optional.ofNullable(oldValue).orElse(0) + 1);
        }
    }

    public Integer count(LottoPlace result) {
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
