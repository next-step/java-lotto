package lotto.domain;

public class Result {

    private final Rank rank;
    private int hitCount;

    public Result(final Rank rank, final int hitCount) {
        this.rank = rank;
        this.hitCount = hitCount;
    }

    public int totalWinningMoney() {
        return rank.totalWinningMoney(hitCount);
    }

    public void addHitCount(final Rank rank) {
        if(this.rank == rank) {
            hitCount++;
        }
    }

    public int getHitCount() {
        return this.hitCount;
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

}
