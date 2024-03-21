package lotto.domian;

import java.util.Objects;

public class PurchaseAmount {
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount of(int purchaseAmount){
        return new PurchaseAmount(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public float calculateTotalProfitRate(long totalWinningAmount) {
        return ((float)totalWinningAmount - purchaseAmount) / purchaseAmount * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseAmount)) return false;
        PurchaseAmount amount = (PurchaseAmount) o;
        return purchaseAmount == amount.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
