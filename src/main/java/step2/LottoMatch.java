package step2;

public enum LottoMatch {
    FOURTH(3, 5000)
    ,THIRD(4, 50000)
    ,SECOND(5, 1500000)
    ,FIRST(6, 2000000000);

    private final int matchCount;
    private final int reward;

    LottoMatch(int matchCount, int reward) {
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
