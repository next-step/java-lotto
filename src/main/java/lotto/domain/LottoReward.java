package lotto.domain;

public class LottoReward {

    private static final int INIT_COUNT = 0;

    private final RewardType rewardType;
    private final int count;

    public LottoReward(RewardType rewardType, int count) {
        this.rewardType = rewardType;
        this.count = count;
    }

    public LottoReward(RewardType rewardType) {
        this(rewardType, INIT_COUNT);
    }

    public RewardType rewardType() {
        return rewardType;
    }

    public int count() {
        return count;
    }
}
