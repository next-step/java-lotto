package step2;

public enum Win {
    FIRST(6, 2000000000)
    ,SECOND(5, 1500000)
    ,THIRD(4, 50000)
    ,FOURTH(3, 5000);

    private int matchCount;
    private int reward;

    Win(int matchCount, int reward) {
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
