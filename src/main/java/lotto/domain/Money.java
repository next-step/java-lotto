package lotto.domain;

public class Money {
    private final long value;

    public Money(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0.");
        }
        this.value = value;
    }

    public int lottoCount(Money price) {
        return (int) (value / price.value);
    }

    public long value() {
        return value;
    }
}
