package lotto.domain.lotto;

public class Money {

    private final int money;

    public Money(int money) {
        checkUnit(money);
        this.money = money;
    }

    private void checkUnit(int money) {
        if (money % Lotto.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException("돈은 1000원 단위여야 합니다.");
        }
    }

    public int amount() {
        return this.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return money;
    }
}
