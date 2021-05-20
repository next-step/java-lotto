package lotto.domain;

import java.util.Objects;

/**
 * 금액.
 */
public class Money {
    private static final String INVALID_PRICE = "로또 최소 가격보다 커야합니다.";
    private static final int LOTTO_PRICE = 1000;
    private final long amount;

    public Money(final long amount) {
        this.amount = validate(amount);
    }

    private long validate(final long amount) {
        if (amount >= LOTTO_PRICE) {
            return amount;
        }
        throw new IllegalArgumentException(INVALID_PRICE);
    }

    /**
     * 구매 가능한 로또 갯수를 리턴한다.
     */
    public int getLottoCount() {
        return (int) amount / LOTTO_PRICE;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return getAmount() == money.getAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount());
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
