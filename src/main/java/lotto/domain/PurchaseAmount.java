package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
    public static final int CONVERTING_FLOOR_NUMBER = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int convertAmountToTryLottoCount() {
        if (purchaseAmount < CONVERTING_FLOOR_NUMBER) {
            throw new IllegalArgumentException();
        }
        return Math.floorDiv(purchaseAmount, CONVERTING_FLOOR_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchaseAmount);
    }
}
