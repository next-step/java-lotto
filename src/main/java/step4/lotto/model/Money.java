package step4.lotto.model;

import step4.lotto.exception.MoneyException;
import step4.lotto.exception.MoneyInvalidFormatException;
import step4.lotto.exception.MoneyInvalidValueException;

public class Money {

    private long value;

    public Money(long value) {
        this.value = value;
    }

    public Money(String value) {
        validateMoney(value);
        this.value = Integer.parseInt(value);
    }

    private void validateMoney(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new MoneyInvalidFormatException();
        }

        if (Integer.parseInt(purchaseAmount) < 0) {
            throw new MoneyInvalidValueException();
        }
    }

    public long value() {
        return value;
    }

    public void add(Money money) {
        this.value += money.value;
    }

    public void subtract(Money money) {
        this.value -= money.value;
    }

}
