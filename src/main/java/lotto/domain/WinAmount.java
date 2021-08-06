package lotto.domain;

public enum WinAmount {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private int matchCount;
    private long reward;

    WinAmount(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinAmount valueOfMatchCount(int matchCount, boolean isMatchBonus) {
        if(matchCount == SECOND.getMatchCount() && !isMatchBonus){
            return THIRD;
        }
        for (WinAmount i : WinAmount.values()) {
            if (matchCount == i.getMatchCount()) {
                return i;
            }
        }
        return FAIL;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getReward() {
        return reward;
    }
}
