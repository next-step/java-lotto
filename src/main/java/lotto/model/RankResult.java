package lotto.model;

import java.util.Objects;

public class RankResult {

    private final Rank rank;

    private final int count;

    public RankResult(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankResult)) return false;
        RankResult that = (RankResult) o;
        return count == that.count && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, count);
    }
}
