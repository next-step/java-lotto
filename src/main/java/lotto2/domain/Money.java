package lotto2.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Money(final int amount) {
        this.amount = validatePrice(amount);
    }

    private int validatePrice(int amount) {
        if (amount >= LOTTO_PRICE) {
            return amount;
        }

        throw new IllegalArgumentException("1000원보다 큰 값을 입력해야합니다.");
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
