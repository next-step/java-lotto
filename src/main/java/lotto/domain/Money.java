package lotto.domain;

public class Money {
    private final long value;

    public Money(long value) {
        this.value = value;
    }

    public int lottoCount(Money price) {
        return (int) (value / price.value);
    }

    public long value() {
        return value;
    }
}
