package lotto;

import lotto.view.PurchaseLimit;

public class ManualCount {

    private final long count;

    public ManualCount(long count, PurchaseLimit purchaseLimit) {
        if (purchaseLimit.isOver(count)) {
            throw new IndexOutOfBoundsException(ErrorMessage.ERR_OVER_COUNT.print());
        }
        this.count = count;
    }

    public AutoCount estimateAuto(long purchaseLimit) {
        if (purchaseLimit < this.count) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_MANUAL_COUNT.print());
        }
        return new AutoCount(purchaseLimit - this.count);
    }

    @Override
    public String toString() {
        return String.valueOf(this.count);
    }
}
