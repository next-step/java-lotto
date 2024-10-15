package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoRewardCountMap {
    private final Map<LottoReward, Integer> value;

    private LottoRewardCountMap(Map<LottoReward, Integer> value) {
        this.value = value;
    }

    public static LottoRewardCountMap valueOf(Map<LottoReward, Integer> rewardCountMap) {
        return new LottoRewardCountMap(rewardCountMap);
    }

    public int getRewardCount(LottoReward reward) {
        return value.getOrDefault(reward, 0);
    }

    public int getTotalReward() {
        int totalReward = 0;
        for (LottoReward reward : value.keySet()) {
            int rewardCount = getRewardCount(reward);
            totalReward += rewardCount * reward.getReward();
        }
        return totalReward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRewardCountMap that = (LottoRewardCountMap) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
