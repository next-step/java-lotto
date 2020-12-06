package lotto.domain;

import lotto.domain.exceptions.InvalidMoneyException;

import java.util.Objects;

public class Money {
    private static final int MIN_AMOUNT = 0;
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int amount;

    public Money(final int amount) {
        validate(amount);

        this.amount = amount;
    }

    public int howManyLottoTickets() {
        return this.amount / LOTTO_TICKET_PRICE;
    }

    private void validate(final int amount) {
        if (amount <= MIN_AMOUNT) {
            throw new InvalidMoneyException("돈은 0원 이상이어야만 합니다.");
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
        return Objects.hash(amount);
    }
}
