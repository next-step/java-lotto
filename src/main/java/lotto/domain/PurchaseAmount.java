package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Lotto;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        valid(amount);
        this.amount = amount;
    }

    private void valid(int amount) {
        if (amount < Lotto.PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_AMOUNT_ERROR);
        }
    }

    public int getLottoCount() {
        return amount / Lotto.PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
