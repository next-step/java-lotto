package lotto.domain;

public class Money {
    private static final int MIN_VALUE = 0;

    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= MIN_VALUE) {
            throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public double calculateRate(int total) {
        return (double) total / value;
    }
}
