package lotto.domain;

import java.util.Objects;

public class WinningResult{
    private Rank rank;
    private int matchCount;

    public WinningResult(Rank rank, int matchCount) {
        this.rank = rank;
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult that = (WinningResult) o;
        return matchCount == that.matchCount && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, matchCount);
    }

    @Override
    public String toString() {
        return "WinningResult{" +
                "rank=" + rank +
                ", matchCount=" + matchCount +
                '}';
    }
}