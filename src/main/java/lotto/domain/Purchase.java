package lotto.domain;

import static lotto.validate.InputValidation.inputValidate;

public class Purchase {

    private static final int LOTTO_AMOUNT = 1000;
    private final int amount;

    public Purchase(int amount) {
        inputValidate(amount);
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public int lottoCount() {
        return amount / LOTTO_AMOUNT;
    }
}
