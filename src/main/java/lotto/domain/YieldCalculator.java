package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class YieldCalculator {
    private int proceedsTotal = 0;

    public YieldCalculator() { }

    public void proceedsCalculate(LinkedHashMap<Integer, Integer> resultMap) {
        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            proceedsTotal += WinningTable.of(entry.getKey()).multiply(entry.getValue());
        }
    }

    public int proceedsTotal() {
        return proceedsTotal;
    }

    public double yield(Amount purchaseAmount) {
        return Double.isInfinite(purchaseAmount.value() / (double) proceedsTotal) ?
                0.0 : purchaseAmount.value() / (double) proceedsTotal;
    }
}
