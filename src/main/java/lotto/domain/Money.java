package lotto.domain;

import static lotto.validate.InputValidation.inputValidate;

public class Money {

    private static final int LOTTO_AMOUNT = 1000;
    private final int price;

    public Money(int price) {
        inputValidate(price);
        this.price = price;
    }

    public int price() {
        return price;
    }

    public int lottoCount() {
        return price / LOTTO_AMOUNT;
    }

    public int autoCount(int manualCount) {
        return lottoCount() - manualCount;
    }
}
