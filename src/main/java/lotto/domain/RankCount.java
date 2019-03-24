package lotto.domain;

import java.util.Objects;

public class RankCount {
    private Rank rank;
    private int matchCount;

    public RankCount(Rank rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long calculate(long money) {
        return matchCount * money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankCount that = (RankCount) o;
        return matchCount == that.matchCount && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, matchCount);
    }

    @Override
    public String toString() {
        return rank + " - " + matchCount + "개";
    }
}