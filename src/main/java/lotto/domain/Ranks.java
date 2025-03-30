package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Ranks {
    List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public List<Rank> values() {
        return ranks;
    }

    public Amount totalWinningMoney() {
        return new Amount(ranks.stream()
                .mapToLong(Rank::winningMoney)
                .sum());
    }

    public float roi(Amount totalAmount) {
        return totalWinningMoney().divide(totalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ranks ranks1 = (Ranks) o;
        return Objects.equals(ranks, ranks1.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ranks);
    }
}
