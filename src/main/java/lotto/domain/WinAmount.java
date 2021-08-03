package lotto.domain;

public enum WinAmount {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private int matchCount;
    private long reward;

    WinAmount(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinAmount valueOfMatchCount(int matchCount) {
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
