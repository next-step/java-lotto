package step2.domain;

public class Money {
    private final int money;

    private Money(final int money) {
        this.money = money;
    }

    public static Money from(final int money) {
        return new Money(money);
    }
}
