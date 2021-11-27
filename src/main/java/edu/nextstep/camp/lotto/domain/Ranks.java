package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class Ranks {
    private final SortedMap<Rank, Integer> ranks;

    private Ranks(Map<Rank, Integer> ranks) {
        this.ranks = Collections.unmodifiableSortedMap(new TreeMap<>(ranks));
    }

    public static Ranks of(final Collection<Rank> ranks) {
        if (ranks == null) {
            throw new IllegalArgumentException("invalid input: ranks cannot be null");
        }

        final Map<Rank, Integer> rankMap = new TreeMap<>();
        for (Rank rank : ranks) {
            rankMap.compute(rank, (r, count) -> count == null ? 1 : count + 1);
        }

        return new Ranks(rankMap);
    }

    public Map<Rank, Integer> collect() {
        return ranks;
    }

    public int amountOfPlace(final Rank rank) {
        return ranks.getOrDefault(rank, 0);
    }

    public Prize totalPrize() {
        return ranks.entrySet().stream()
                .map(entry -> entry.getKey()
                        .prize()
                        .multiply(entry.getValue()))
                .reduce(Prize::add)
                .orElse(Prize.NO_PRIZE);
    }

    public int size() {
        return ranks.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks other = (Ranks) o;
        return ranks.entrySet().containsAll(other.ranks.entrySet())
                && other.ranks.entrySet().containsAll(ranks.entrySet());
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
