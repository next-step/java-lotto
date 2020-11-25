package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Objects;

public class Prize {
    private final Rank rank;
    private final Cash cash;
    private final String ruleDescription;

    public Prize(Rank rank, Cash cash, String ruleDescription) {
        this.rank = rank;
        this.cash = cash;
        this.ruleDescription = ruleDescription;
    }

    public Rank getRank() {
        return rank;
    }

    public Cash getCash() {
        return cash;
    }

    public String getRuleDescription() {
        return this.ruleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return rank == prize.rank &&
                cash.equals(prize.cash) &&
                ruleDescription.equals(prize.ruleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, cash, ruleDescription);
    }
}
