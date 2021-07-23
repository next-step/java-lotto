package lotto.money;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money init(int payment) {
        return new Money(payment);
    }
}
