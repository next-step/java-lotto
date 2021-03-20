package lotto.domain;

import java.util.LinkedHashMap;

public class LottoResult {
    private final LinkedHashMap<Integer, Integer> resultMap;
    private final Amount purchaseAmount;

    public LottoResult(final LinkedHashMap<Integer, Integer> resultMap,final Amount purchaseAmount) {
        this.resultMap = resultMap;
        this.purchaseAmount = purchaseAmount;
    }

    public LinkedHashMap<Integer, Integer> resultMap() {
        return resultMap;
    }

    public double yield() {
        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculator.proceedsCalculate(resultMap);
        return yieldCalculator.yield(purchaseAmount);
    }
}
