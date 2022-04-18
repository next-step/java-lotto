package lotto.model;

public class Money {

    private static final long ZERO = 0;

    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다");
        }
    }

    public long getValue() {
        return value;
    }

}
