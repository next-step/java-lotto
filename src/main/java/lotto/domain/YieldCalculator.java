package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class YieldCalculator {
    private final Amount purchaseAmount;
    private int proceedsTotal = 0;

    public YieldCalculator(final Amount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void proceedsCalculate(LinkedHashMap<Integer, Integer> resultMap) {
        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            proceedsTotal += WinningTable.of(entry.getKey()).multiply(entry.getValue());
        }
    }

    public int proceedsTotal() {
        return proceedsTotal;
    }

    public double yield() {
        return Double.isInfinite(purchaseAmount.value() / (double) proceedsTotal) ?
                0.0 : purchaseAmount.value() / (double) proceedsTotal;
    }
}
