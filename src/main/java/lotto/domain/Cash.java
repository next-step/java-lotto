package lotto.domain;

import lotto.domain.enums.Currency;

import java.util.Objects;

public class Cash implements Comparable<Cash> {
    private static final String CASH_STRING_FORMAT = "%s %s";
    private Long amount;
    private final Currency currency;

    public Cash(Long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Cash(Cash cash) {
        this.amount = cash.amount;
        this.currency = cash.currency;
    }

    public Long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return amount.equals(cash.amount) &&
                currency == cash.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return String.format(CASH_STRING_FORMAT, amount, currency.getDescription());
    }

    @Override
    public int compareTo(Cash o) {
        return amount.compareTo(o.amount);
    }

    public void accumulate(Cash cash) {
        this.amount = this.amount + cash.amount;
    }
}
