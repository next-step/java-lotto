package lotto.domain;

public class Money {

    private static final int THOUSAND = 1000;

    private final int money;

    public Money(final int money) {
        this.money = money;
    }

    public int divideByThousand() {
        return money / THOUSAND;
    }

    public int getMoney() {
        return money;
    }
}
