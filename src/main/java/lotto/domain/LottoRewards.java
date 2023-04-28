package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRewards {

    private static final int BEGIN_INDEX = 0;
    private static final int INCREASE_COUNT = 1;
    private final List<LottoReward> rewards = new ArrayList<>();

    public boolean isNotContainRewardType(RewardType rewardType) {
        return !isContainRewardType(rewardType);
    }

    private boolean isContainRewardType(RewardType rewardType) {
        for (LottoReward reward : rewards) {
            if (isSameRewardType(rewardType, reward)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameRewardType(RewardType rewardType, LottoReward reward) {
        return reward.rewardType() == rewardType;
    }

    public void add(LottoReward lottoReward) {
        rewards.add(lottoReward);
    }

    public void increaseCountOf(RewardType rewardType) {
        for (int i = BEGIN_INDEX; i < rewards.size(); i++) {
            if (isSameRewardType(rewardType, i)) {
                increaseCountRewardOf(i);
                break;
            }
        }
    }

    private void increaseCountRewardOf(int i) {
        rewards.set(i, new LottoReward(
                rewards.get(i).rewardType(),
                rewards.get(i).count() + INCREASE_COUNT)
        );
    }

    private boolean isSameRewardType(RewardType rewardType, int i) {
        return rewards.get(i).rewardType() == rewardType;
    }

    public LottoReward get(RewardType rewardType) {
        for (LottoReward reward : rewards) {
            if (isSameRewardType(rewardType, reward)) {
                return reward;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "LottoRewards{" +
                "rewards=" + rewards +
                '}';
    }
}
