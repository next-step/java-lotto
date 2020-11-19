package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;

import java.util.Objects;

public class Prize {
    private static final String CASH_STRING_FORMAT = "%s %s";
    private final Rank rank;
    private final Long cash;
    private final Currency currency;

    public Prize(Rank rank, Long cash, Currency currency) {
        this.rank = rank;
        this.cash = cash;
        this.currency = currency;
    }

    public Rank getRank() {
        return rank;
    }

    public Long getCash() {
        return cash;
    }

    public String getCashString() {
        return String.format(CASH_STRING_FORMAT, cash.toString(),currency.getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return rank == prize.rank &&
                cash.equals(prize.cash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, cash);
    }
}
