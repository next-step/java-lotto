package lotto.domain;

public enum Rank {
    FIRST(6, 200000000),
    SECOND(6, 15000000),
    THIRD(5, 1000000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
