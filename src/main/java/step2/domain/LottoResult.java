package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoTier, Integer> result = new HashMap<>();

    public LottoResult(Map<LottoTier, Integer> result) {
        this.result = result;
    }

    public Integer getTotalPrize() {
        Integer totalPrize = 0;

        for(LottoTier key : result.keySet()) {
            totalPrize = totalPrize + key.calculatePrize(result.get(key));
        }
        return totalPrize;
    }

    public int getTierCount(LottoTier lottoTier) {
        return result.get(lottoTier);
    }

    public double getYield(int money) {
        return getTotalPrize() / Double.valueOf(money);
    }
}
