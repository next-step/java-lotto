package step2;

public enum LottoMatch {
    FOURTH(3.0, 5000)
    ,THIRD(4.0, 50000)
    ,SECOND(5.0, 1500000)
    ,SECOND_BONUS(5.5, 30000000)
    ,FIRST(6.0, 2000000000);

    private final double matchCount;
    private final int reward;

    LottoMatch(double matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public double getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
