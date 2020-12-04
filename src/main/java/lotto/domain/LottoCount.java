package lotto.domain;

import lotto.constant.ErrorMessage;

public class LottoCount {
    private final int value;

    public LottoCount(int value, PurchaseAmount purchaseAmount) {
        this.value = value;
        valid(purchaseAmount);
    }

    private void valid(PurchaseAmount purchaseAmount) {
        if (!purchaseAmount.canBuy(value)) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_BUY_LOTTO);
        }
    }

    public int getValue() {
        return value;
    }
}
