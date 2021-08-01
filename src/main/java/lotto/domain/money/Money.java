package lotto.domain.money;

public class Money {
    public static final int MIN_AMOUNT = 0;
    public static final Money MIN = Money.of(MIN_AMOUNT);

    private final int amount;

    private Money(int money) {
        validate(money);
        this.amount = money;
    }

    private void validate(int money) {
        if (money < MIN_AMOUNT) {
            throw new IllegalStateException("Money값은 " + MIN_AMOUNT + " 이상 이어야합니다.");
        }
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int getAmount() {
        return amount;
    }

    public int getAffordableCount(Money baseMoney) {
        return this.amount / baseMoney.amount;
    }

    public Money addition(Money anotherMoney) {
        return Money.of(amount + anotherMoney.getAmount());
    }

    public Money multiply(int operand) {
        return Money.of(amount * operand);
    }

    public double earningRate(Money money) {
        return (double) this.amount / money.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
