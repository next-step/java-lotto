package lotto.domain;

public class LottoReward {

    private final RewardType rewardType;
    private final int count;

    public LottoReward(RewardType rewardType, int count) {
        this.rewardType = rewardType;
        this.count = count;
    }

    public RewardType rewardType() {
        return rewardType;
    }

    public int count() {
        return count;
    }
}
