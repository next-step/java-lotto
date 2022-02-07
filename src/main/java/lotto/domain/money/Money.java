package lotto.domain.money;

import lotto.util.MoneyValidator;

public class Money {

    private final int value;

    public Money(String input) {
        this(MoneyValidator.parseToInt(input));
    }

    public Money(int value) {
        this.value = MoneyValidator.validate(value);
    }

    public int getValue() {
        return value;
    }
}
