package lotto.domain;

public class RankCount {

    private LotteryRank rank;
    private long winningCount;

    public RankCount(LotteryRank rank, long winningCount) {
        this.rank = rank;
        this.winningCount = winningCount;
    }

    public long winningCount() {
        return this.winningCount;
    }

    public boolean isEqualWithRank(LotteryRank rank) {
        return this.rank.equals(rank);
    }
}
