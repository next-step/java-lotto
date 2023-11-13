package src.domain;

public class Money {

    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public int lottoCount(int lottoPrice) {
        return value / lottoPrice;
    }
}
