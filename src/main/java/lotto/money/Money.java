package lotto.money;

public class Money {
    public static final int ZERO_VALUE = 0;
    public static final Money ZERO = Money.init(ZERO_VALUE);

    private final int money;

    public Money(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (money < ZERO_VALUE) {
            throw new IllegalArgumentException("Money value should be equal or greater than " + ZERO_VALUE);
        }
    }

    public static Money init(int payment) {
        return new Money(payment);
    }

    public int getAffordableCount(Money price) {
        return this.money / price.money;
    }

    public int toInt() {
        return money;
    }

    public Money addition(Money anotherMoney) {
        return Money.init(money + anotherMoney.money);
    }

    public int multiply(int operand) {
        return money * operand;
    }

    public double earningRate(Money payment) {
        return (double) payment.money / this.money;
    }
}
