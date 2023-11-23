package lotto.domain;

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
}
