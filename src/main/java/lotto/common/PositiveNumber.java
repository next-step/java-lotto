package lotto.common;

public class PositiveNumber {
    private long number;

    private PositiveNumber(long number) {
        validate(number);
        this.number = number;
    }

    public static PositiveNumber of(long number) {
        return new PositiveNumber(number);
    }

    private void validate(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number range");
        }
    }

    public long get() {
        return number;
    }
}