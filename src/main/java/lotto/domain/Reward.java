package lotto.domain;

import lotto.util.RewardTable;

import java.util.Iterator;
import java.util.Map;

public class Reward {

    private int totalRewardPrice;

    public Reward() {
        this.totalRewardPrice = 0;
    }

    public int sumTotalMatchPrice(Map<RewardTable, Integer> map) {
        Iterator<RewardTable> keys = map.keySet().iterator();

        while (keys.hasNext()) {
            RewardTable key = keys.next();
            int value = map.get(key);

            this.totalRewardPrice += sumMatchPrice(key, value);
        }

        return this.totalRewardPrice;
    }

    private int sumMatchPrice(RewardTable key, int value) {
        return key.matchReward(value);
    }
}
