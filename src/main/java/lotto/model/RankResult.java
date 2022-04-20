package lotto.model;

import java.util.Objects;

public class RankResult {

    private final Rank rank;

    private final long count;

    public RankResult(Rank rank, long count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

    public long getCount() {
        return count;
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
