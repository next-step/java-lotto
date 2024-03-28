package lotto.domain.lotto;

import static lotto.utils.Constants.LOTTO_TICKET_PRICE;

import lotto.error.exception.PurchaseAmountException;

public class PurchaseInfomation {

    private int purchaseAmount;

    private int manualPurchaseCount;

    public PurchaseInfomation(int purchaseAmount) {
        this(purchaseAmount, 0);
    }

    public PurchaseInfomation(int purchaseAmount, int manualPurchaseCount) {
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new PurchaseAmountException(purchaseAmount);
        }

        this.purchaseAmount = purchaseAmount;
        this.manualPurchaseCount = manualPurchaseCount;
    }

    public int autoPurchaseCount() {
        return (purchaseAmount / LOTTO_TICKET_PRICE) - manualPurchaseCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }
}
