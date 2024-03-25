package lotto.view;

import lotto.AutoCount;
import lotto.ManualCount;
import lotto.Money;

public class PurchaseLimit {

    private final long limitCount;

    public PurchaseLimit(Money budget, Money lottoPrice) {
        this(estimatePurchaseLimit(budget, lottoPrice));
    }

    private static long estimatePurchaseLimit(Money budget, Money lottoPrice) {
        return budget.estimatePurchaseLimit(lottoPrice);
    }

    public PurchaseLimit(long limitCount) {
        this.limitCount = limitCount;
    }

    public AutoCount decrease(ManualCount manualCount) {
        return manualCount.estimateAuto(this.limitCount);
    }

    public boolean isOver(long count) {
        return limitCount < count;
    }
}
