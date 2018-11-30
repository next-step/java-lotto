package lotto.domain;

public class Money {
    private final static int DIVISOR = 1_000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTotalCount() {
        return money / DIVISOR;

    }

    public double calculateRate(Money prize) {
        return (prize.money * 100) / this.money;
    }


}
