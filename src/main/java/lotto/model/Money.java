package lotto.model;

import java.util.Objects;

import static lotto.validation.MoneyValidator.assertMoney;

public class Money {
    public static final int LOTTO_PER_MONEY = 1_000;

    private final int amount;

    public Money(int amount) {
        assertMoney(amount);
        this.amount = amount;
    }

    public int maxQuantity() {
        return this.amount / LOTTO_PER_MONEY;
    }

    public void assertPurchasable(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("음수 값은 허용하지 않습니다");
        }

        if (maxQuantity() < quantity) {
            throw new IllegalArgumentException("수동 구매 로또 개수가 최대 구매 개수를 초과할 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Money money = (Money) other;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
