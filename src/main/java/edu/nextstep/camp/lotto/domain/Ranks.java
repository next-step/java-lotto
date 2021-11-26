package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Ranks {
    private final Collection<Rank> ranks;

    private Ranks(Collection<Rank> ranks) {
        this.ranks = Collections.unmodifiableCollection(ranks);
    }

    public static Ranks of(final Collection<Rank> ranks) {
        if (ranks == null) {
            throw new IllegalArgumentException("invalid input: ranks cannot be null");
        }

        return new Ranks(ranks);
    }

    public Collection<Rank> collect() {
        return ranks;
    }

    public int amountOfPlace(final Rank rank) {
        return (int) ranks.stream()
                .filter(r -> r.equals(rank))
                .count();
    }

    public Prize totalPrize() {
        return ranks.stream()
                .map(Rank::prize)
                .reduce(Prize::add)
                .orElse(Prize.NO_PRIZE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks other = (Ranks) o;
        return ranks.containsAll(other.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }

    @Override
    public String toString() {
        return "Ranks{" +
                "ranks=" + ranks +
                '}';
    }
}
