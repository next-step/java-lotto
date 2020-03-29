package step2.domain;

import java.util.Map;

public class LottoResult {

    private final Map<LottoTier, Integer> result;

    public LottoResult(Map<LottoTier, Integer> result) {
        this.result = result;
    }

    public int getTierCount(LottoTier tier) {
        return result.get(tier);
    }

    public long getTotalPrize() {
        long totalPrize = 0;

        for(LottoTier key : result.keySet()) {
            totalPrize = totalPrize + key.calculatePrize(result.get(key));
        }
        return totalPrize;
    }

    public double getYield(Money money) {
        return getTotalPrize() / Long.valueOf(money.getMoney());
    }
}
