package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public double profitRate(Money price) {
        return money / (double) price.money;
    }
}
