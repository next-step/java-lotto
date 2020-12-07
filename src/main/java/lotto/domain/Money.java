package lotto.domain;

import lotto.domain.exceptions.InvalidMoneyException;

import java.util.Objects;

public class Money {
    private static final Long MIN_VALUE = 0L;
    private static final Long LOTTO_TICKET_PRICE = 1000L;

    private final Long amount;

    public Money(final Long amount) {
        validate(amount);

        this.amount = amount;
    }

    public Long howManyLottoTickets() {
        return this.amount / LOTTO_TICKET_PRICE;
    }

    public Money multiply(final Long count) {
        return new Money(count);
    }

    private void validate(final Long amount) {
        if (amount <= MIN_VALUE) {
            throw new InvalidMoneyException("돈은 0원 이상이어야만 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
