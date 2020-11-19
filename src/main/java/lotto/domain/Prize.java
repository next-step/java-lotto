package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Objects;

public class Prize {
    private final Rank rank;
    private final Long cash;

    public Prize(Rank rank, Long cash) {
        this.rank = rank;
        this.cash = cash;
    }

    public Rank getRank() {
        return rank;
    }

    public Long getCash() {
        return cash;
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
