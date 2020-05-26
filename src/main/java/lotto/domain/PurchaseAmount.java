package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

    private static final int LOTTO_SALE_PRICE = 1000;

    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount newInstance(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < LOTTO_SALE_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000원 이상 이어야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int calculatePurchaseCount() {
        return this.purchaseAmount / LOTTO_SALE_PRICE;
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
        return Objects.hash(purchaseAmount);
    }
}
