package lotto.domain;

import java.util.Objects;

public class Result {

    private final Rank rank;
    private int hitsCount;

    public Result(final Rank rank, final int hitsCount) {
        this.rank = rank;
        this.hitsCount = hitsCount;
    }

    public int calculateTotalWinningMoney() {
        return rank.totalWinningMoney(hitsCount);
    }

    public void addHitsCount(final Rank rank) {
        if (this.rank == rank) {
            hitsCount++;
        }
    }

    public int getHitsCount() {
        return this.hitsCount;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getMatchingCount() {
        return this.rank.getMatchingCount().getValue();
    }

    public int getWinningMoney() {
        return this.rank.getWinningMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return rank == result.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, hitsCount);
    }

}
