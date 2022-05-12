package lotto.domain;

import java.util.Objects;

public class Quantity {
    private static final String EXCEED_QUANTITY_MESSAGE = "수량을 초과하였습니다.";

    private final int maxPurchasableQuantity;
    private final int purchasedQuantity;

    public Quantity(int maxPurchasableQuantity, int purchasedQuantity) {
        this.maxPurchasableQuantity = maxPurchasableQuantity;
        this.purchasedQuantity = purchasedQuantity;
        validate(maxPurchasableQuantity, purchasedQuantity);
    }

    private void validate(int maxPurchasableQuantity, int purchasedQuantity) {
        if (maxPurchasableQuantity < purchasedQuantity) {
            throw new IllegalArgumentException(EXCEED_QUANTITY_MESSAGE + this);
        }
    }

    public Quantity increase() {
        return new Quantity(maxPurchasableQuantity, purchasedQuantity + 1);
    }

    public boolean isPurchasable() {
        return maxPurchasableQuantity > purchasedQuantity;
    }

    public int getMaxPurchasableQuantity() {
        return maxPurchasableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return maxPurchasableQuantity == quantity.maxPurchasableQuantity && purchasedQuantity == quantity.purchasedQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPurchasableQuantity, purchasedQuantity);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "maxPurchasableQuantity=" + maxPurchasableQuantity +
                ", purchasedQuantity=" + purchasedQuantity +
                '}';
    }
}
