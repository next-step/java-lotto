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

    public Money minus(Money money) {
        int minusValue = value - money.value;
        if (minusValue < 0) {
            throw new IllegalArgumentException("Money는 음수일 수 없습니다.");
        }

        return new Money(minusValue);
    }
}
