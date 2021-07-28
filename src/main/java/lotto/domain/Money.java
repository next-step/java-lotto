package lotto.domain;

public class Money {
    private static final int LOWEST_AMOUNT = 1000;
    private final int amount;

    private Money(int money) {
        validate(money);
        this.amount = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    private void validate(int money) {
        if (money < LOWEST_AMOUNT) {
            throw new IllegalArgumentException(LOWEST_AMOUNT + " 보다 작을 수 없습니다.");
        }
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
