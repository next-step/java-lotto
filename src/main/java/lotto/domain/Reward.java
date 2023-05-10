package lotto.domain;

import lotto.util.RewardTable;

import java.util.Iterator;
import java.util.Map;

public class Reward {

    private Long totalRewardPrice;

    public Reward() {
        this.totalRewardPrice = 0L;
    }

    public Long sumTotalMatchPrice(Map<RewardTable, Long> map) {
        Iterator<RewardTable> keys = map.keySet().iterator();

        while (keys.hasNext()) {
            RewardTable key = keys.next();
            Long value = map.get(key);

            this.totalRewardPrice += sumMatchPrice(key, value);
        }

        return this.totalRewardPrice;
    }

    private Long sumMatchPrice(RewardTable key, Long value) {
        return key.matchReward(value);
    }
}
