package step2.lotto.model;

import step2.lotto.exception.MoneyException;

public class Money {

    private final int value;

    public Money() {
        value = 0;
    }

    public Money(String purchaseAmount) {
        validate(purchaseAmount);
        value = Integer.parseInt(purchaseAmount);

    }

    private void validate(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new MoneyException();
        }

        if (Integer.parseInt(purchaseAmount) < 0) {
            throw new MoneyException();
        }
    }

    public int value() {
        return value;
    }

}
