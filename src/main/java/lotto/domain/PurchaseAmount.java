package lotto.domain;

import lotto.LottoConfig;

public class PurchaseAmount {
    int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(LottoConfig.PURCHASE_AMOUNT_MINUS_ERROR_MESSAGE);
        }
    }

    public int getLottoCount(){
        return purchaseAmount / LottoConfig.LOTTO_PRICE;
    }
}
