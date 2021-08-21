package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validInput(money);
        this.money = money;
    }

    private void validInput(int money) {
        if (money < 1000) {
            throw new LottoPurchaseAmountException();
        }
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }
}
