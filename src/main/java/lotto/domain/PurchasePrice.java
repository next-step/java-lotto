package lotto.domain;

import java.util.Objects;

public class PurchasePrice {

    private static final int LOTTO_SALE_PRICE = 1000;

    private final int purchasePrice;

    private PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static PurchasePrice newInstance(int purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validate(int purchasePrice) {
        if (purchasePrice < LOTTO_SALE_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000원 이상 이어야 합니다.");
        }
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public int calculatePurchaseCount() {
        return this.purchasePrice / LOTTO_SALE_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice);
    }
}
