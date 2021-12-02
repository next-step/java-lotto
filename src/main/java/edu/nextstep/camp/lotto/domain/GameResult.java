package edu.nextstep.camp.lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<Rank, Long> ranks;

    private GameResult(Map<Rank, Long> ranks) {
        this.ranks = Collections.unmodifiableSortedMap(new TreeMap<>(ranks));
    }

    public static GameResult of(final Collection<Rank> ranks) {
        if (ranks == null) {
            throw new IllegalArgumentException("invalid input: ranks cannot be null");
        }

        final Map<Rank, Long> rankMap = ranks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new GameResult(rankMap);
    }

    public Map<Rank, Long> collect() {
        return ranks;
    }

    public Prize totalPrize() {
        return ranks.entrySet().stream()
                .map(entry -> entry.getKey()
                        .prize()
                        .multiply(entry.getValue()))
                .reduce(Prize::add)
                .orElse(Prize.NO_PRIZE);
    }

    public long size() {
        return ranks.values()
                .stream()
                .reduce(Long::sum)
                .orElse(0L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult other = (GameResult) o;
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

    public float priceEarningRate() {
        return (float) totalPrize().toLong() / (size() * Store.GAME_PRICE);
    }
}
