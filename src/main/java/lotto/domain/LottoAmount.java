package lotto.domain;

import lotto.constant.ErrorMessage;

public class LottoAmount {

    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoAmount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    private void valid(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_ERROR);
        }
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
