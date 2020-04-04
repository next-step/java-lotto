package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final long amount;

    public Money(final long amount) {
        this.amount = validatePrice(amount);
    }

    private long validatePrice(long amount) {
        if (amount >= LOTTO_PRICE) {
            return amount;
        }

        throw new IllegalArgumentException("1000원보다 큰 값을 입력해야합니다.");
    }

    public long getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public long getAmount() {
        return amount;
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
