package edu.nextstep.camp.lotto.domain;

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

    public Prize totalPrize() {
        return ranks.totalPrize();
    }

    public long amountOfPlace(Rank rank) {
        return ranks.amountOfPlace(rank);
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
