package edu.nextstep.camp.lotto.domain;

import java.util.Map;
import java.util.Objects;

public class GameResult {
    private final Ranks ranks;

    private GameResult(Ranks ranks) {
        this.ranks = ranks;
    }

    public static GameResult of(Ranks ranks) {
        if (ranks == null) {
            throw new IllegalArgumentException("invalid input: ranks cannot be null.");
        }

        return new GameResult(ranks);
    }

    public Map<Rank, Integer> collect() {
        return ranks.collect();
    }

    public Prize totalPrize() {
        return ranks.totalPrize();
    }

    public float priceEarningRate() {
        return (float) ranks.totalPrize().toLong() / (ranks.size() * Store.GAME_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "ranks=" + ranks +
                '}';
    }
}
