package step2.model;

public enum WinnerTier {
    MATCH_SIX(2000000000, 6),
    MATCH_FIVE(1500000, 5),
    MATCH_FOUR(50000, 4),
    MATCH_THREE(5000, 3);

    private final long prize;
    private final int matchCnt;

    WinnerTier(long prize, int matchCnt) {
        this.prize = prize;
        this.matchCnt = matchCnt;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCnt() {
        return matchCnt;
    }
}
