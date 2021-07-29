package lotto.domain.money;

public class Money {
    public static final int LOWEST_AMOUNT = 1_000;
    private final int amount;

    private Money(int money) {
        this.amount = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int getPurchasableQuantity(Money price) {
        return amount / price.getAmount();
    }

    public int getAmount() {
        return amount;
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
