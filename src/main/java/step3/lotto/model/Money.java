package step3.lotto.model;

import step3.lotto.exception.MoneyException;

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
            throw new MoneyException();
        }

        if (Integer.parseInt(purchaseAmount) < 0) {
            throw new MoneyException();
        }
    }

    public long value() {
        return value;
    }

    public void add(Money money) {
        this.value += money.value;
    }

}
