package lotto.domain;

import java.util.Objects;

public class TryLottoCount {
    private int tryLottoCount;
    private PurchaseAmount purchaseAmount;
    public TryLottoCount(int tryLottoCount, int purchaseAmount) {
        this.tryLottoCount = tryLottoCount;
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
    }

    public int currentCount() {
        return tryLottoCount;
    }

    public int calculateLottoTryCount() {
        tryLottoCount = purchaseAmount.convertAmountToTryLottoCount();
        return tryLottoCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryLottoCount that = (TryLottoCount) o;
        return tryLottoCount == that.tryLottoCount && Objects.equals(purchaseAmount, that.purchaseAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryLottoCount, purchaseAmount);
    }
}
