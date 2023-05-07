package lotto.domain;

import lotto.util.RewardTable;

import java.util.Iterator;
import java.util.Map;

public class Reward {

    private int totalRewardPrice;

    public Reward() {
    }

    public int sumTotalMatchPrice(Map<Integer, Integer> map) {
        this.totalRewardPrice = 0;

        Iterator<Integer> keys = map.keySet().iterator();

        while (keys.hasNext()) {
            int key = keys.next();
            int value = map.get(key);

            this.totalRewardPrice += sumMatchPrice(key, value);
        }

        return this.totalRewardPrice;
    }

    private int sumMatchPrice(int key, int value) {
        return RewardTable.of(key).matchReward(value);
    }
}
