package domain.type;

public enum LottoRewardAmount {
    FIRST_REWARD(2000000000),
    SECOND_REWARD(30000000),
    THIRD_REWARD(1500000),
    FOURTH_REWARD(50000),
    FIFTH_REWARD(5000),
    ETC_REWARD(0);

    private int reward;

    private LottoRewardAmount(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return this.reward;
    }
}
