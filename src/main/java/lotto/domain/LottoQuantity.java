package lotto.domain;

import lotto.constant.LottoConstant;

public class LottoQuantity {
    private final int lottoQuantity;

    public LottoQuantity(int buyAmount) {
        this.lottoQuantity = amountToQuantity(buyAmount);
    }

    private void isBuyAmountValid(int buyAmount) {
        if (buyAmount < LottoConstant.MIN_BUY_AMOUNT) {
            throw new IllegalArgumentException(LottoConstant.BUY_AMOUNT_ERROR);
        }
    }

    private int amountToQuantity(int buyAmount) {
        isBuyAmountValid(buyAmount);
        return buyAmount / LottoConstant.MIN_BUY_AMOUNT;
    }

    public int lottoQuantity() {
        return this.lottoQuantity;
    }
}
