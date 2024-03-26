package lotto.domain.lotto;

import static lotto.utils.constants.LOTTO_TICKET_PRICE;

import lotto.error.exception.PurchaseAmountException;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_TICKET_PRICE != 0) {
            throw new PurchaseAmountException(purchaseAmount);
        }

        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
