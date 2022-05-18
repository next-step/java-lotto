package lotto.domain.result;

public class PurchaseAmount {
    int purchaseAmount;

    PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    double yield(long totalReward) {
        return (double) totalReward / purchaseAmount;
    }
}
