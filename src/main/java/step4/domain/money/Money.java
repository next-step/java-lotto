package step4.domain.money;

public class Money {

    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

}
