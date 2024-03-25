package lotto.domain.lotto;

import lotto.error.exception.PurchaseAmountException;

public class PurchaseAmount {

    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new PurchaseAmountException(purchaseAmount);
        }

        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
