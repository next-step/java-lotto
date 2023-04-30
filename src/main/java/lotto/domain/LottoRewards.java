package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRewards {

    private static final int INCREASE_COUNT = 1;
    private static final long TOTAL_PROFIT_INIT = 0l;

    private final List<LottoReward> rewards = new ArrayList<>();

    public boolean isNotContainRewardType(RewardType rewardType) {
        return rewards.stream()
                .allMatch(v -> v.rewardType() != rewardType);
    }

    public void add(LottoReward lottoReward) {
        rewards.add(lottoReward);
    }

    public void increaseCountOf(RewardType rewardType) {
        rewards.stream()
                .filter(v -> v.rewardType() == rewardType)
                .forEach(v -> rewards.set(rewards.indexOf(v),
                                new LottoReward(v.rewardType(), v.count() + INCREASE_COUNT)
                        )
                );
    }

    public LottoReward get(RewardType rewardType) {
        return rewards.stream()
                .filter(v -> v.rewardType() == rewardType)
                .findAny()
                .orElse(null);
    }

    public long totalProfit() {
        long totalProfit = TOTAL_PROFIT_INIT;

        for (LottoReward reward : rewards) {
            totalProfit += reward.count() * reward.rewardType().reward();
        }

        return totalProfit;
    }

}
