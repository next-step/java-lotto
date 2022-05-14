package lotto.domain;

import java.util.Objects;

public class Quantity {
    private static final String EXCEED_QUANTITY_MESSAGE = "수량을 초과하였습니다.";

    private final int maxPurchasableQuantity;
    private final int purchasedQuantity;
    private final int manualBuyQuantity;

    public Quantity(int maxPurchasableQuantity, String manualBuyQuantity) {
        this(maxPurchasableQuantity, Integer.parseInt(manualBuyQuantity), Integer.parseInt(manualBuyQuantity));
    }

    private Quantity(int maxPurchasableQuantity, int manualBuyQuantity, int purchasedQuantity) {
        this.maxPurchasableQuantity = maxPurchasableQuantity;
        this.manualBuyQuantity = manualBuyQuantity;
        this.purchasedQuantity = purchasedQuantity;
        validate();
    }

    private void validate() {
        if (maxPurchasableQuantity < purchasedQuantity) {
            throw new IllegalArgumentException(EXCEED_QUANTITY_MESSAGE + this);
        }
    }

    public Quantity increase() {
        return new Quantity(maxPurchasableQuantity, manualBuyQuantity, purchasedQuantity + 1);
    }

    public boolean isPurchasable() {
        return maxPurchasableQuantity > purchasedQuantity;
    }

    public int getMaxPurchasableQuantity() {
        return maxPurchasableQuantity;
    }

    public int getManualBuyCount() {
        return this.manualBuyQuantity;
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
