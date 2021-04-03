package step3.domain.money;

public final class Money {

    private final int money;

    private Money (int money) {
        this.money = money;
    }

    public static Money valueOf(int money) {
        return new Money(money);
    }

}
