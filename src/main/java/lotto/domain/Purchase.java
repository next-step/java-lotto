package lotto.domain;

import static lotto.validate.InputValidation.inputValidate;

public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        inputValidate(amount);
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

}
