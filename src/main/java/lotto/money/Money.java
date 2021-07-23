package lotto.money;

public class Money {
    public static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException("Money value should be equal or greater than " + ZERO);
        }
    }

    public static Money init(int payment) {
        return new Money(payment);
    }

    public boolean getAffordableCount(Money price) {
        return false;
    }
}
