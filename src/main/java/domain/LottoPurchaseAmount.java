package domain;

import java.util.Objects;

public class LottoPurchaseAmount {
    public static final int PRICE = 1_000;

    private static final int ZERO_REMAINDER = 0;

    private final int purchaseAmount;

    public LottoPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = validatePurchaseAmount(purchaseAmount);
    }

    public static LottoPurchaseAmount of(int purchaseAmount) {
        return new LottoPurchaseAmount(purchaseAmount);
    }

    private int validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PRICE != ZERO_REMAINDER) {
            throw new IllegalArgumentException(String.format("Purchase amount must be multiples of %d", PRICE));
        }

        return purchaseAmount;
    }

    public int amount() {
        return purchaseAmount / PRICE;
    }

    public double profitRate(int totalProfit) {
        return (double) totalProfit / purchaseAmount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoPurchaseAmount that = (LottoPurchaseAmount) object;

        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
