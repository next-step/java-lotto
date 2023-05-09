package lotto.domain;

public class Money {

    private final int amount;

    public Money(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
        this.amount = amount;
    }

    public int buyCount(int price) {
        return this.amount / price;
    }

    public double ratio(int value) {
        return (double) value / amount;
    }
}
