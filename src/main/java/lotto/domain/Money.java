package lotto.domain;

public class Money {
    private final int LOTTO_PRICE = 1_000;

    private final int value;

    public Money(final String value) {
        this(Integer.parseInt(value));
    }

    public Money(final int value) {
        this.value = value;
    }

    public int lottoCount() {
        return this.value / LOTTO_PRICE;
    }
}
