package step2.lotto.model;

import step2.lotto.exception.MoneyException;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
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

    public void add(Money money) {
        this.value += money.value;
    }

    public void multiply(Count count) {
        this.value *= count.value();
    }

}
