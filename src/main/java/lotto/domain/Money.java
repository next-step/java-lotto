package lotto.domain;

public class Money {
    private static final int PRICE = 1000;
    private final int money;

    public Money(int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("음수 값이 들어올 수 없습니다.");
        }
    }

    public int value() {
        return this.money;
    }

    public int getBuyableCount() {
        return this.money / PRICE;
    }

    public double getYield(int total) {
        return total / (double) this.money;
    }
}
