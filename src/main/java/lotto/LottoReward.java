package lotto;

public enum LottoReward {

    FIRST(2000000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);

    private int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int reward() {
        return reward;
    }
}
