package lotto.domain;

public class Money {

    private final static int MIN_MONEY = 0;
    private final static String ERROR_MESSAGE = "금액은 0원 이상이어야 합니다.";
    private final int value;

    public Money(final int value) {
        validateMoney(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Money multiple(int hit) {
        return new Money(value * hit);
    }

    private void validateMoney(final int value) {
        if (value < MIN_MONEY) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
