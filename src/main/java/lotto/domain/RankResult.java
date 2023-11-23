package lotto.domain;

import java.util.Objects;

public class RankResult {
    private final Rank rank;
    private final long rankCnt;

    public RankResult(Rank rank, long rankCnt) {
        this.rank = rank;
        this.rankCnt = rankCnt;
    }

    public Rank getRank() {
        return rank;
    }

    public long getRankCnt() {
        return rankCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RankResult that = (RankResult) o;
        return rankCnt == that.rankCnt && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, rankCnt);
    }
}
