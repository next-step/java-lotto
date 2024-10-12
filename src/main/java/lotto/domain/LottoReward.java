package lotto.domain;

public enum LottoReward {
    FORTH_PLACE(5000, 3),
    THIRD_PLACE(50000, 4),
    SECOND_PLACE(1500000, 5),
    FIRST_PLACE(2000000000, 6);

    private final int reward;
    private final int matchCount;

    LottoReward(int reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
