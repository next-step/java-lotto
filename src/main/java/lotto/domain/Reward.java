package lotto.domain;

import lotto.util.RewardTable;

import java.util.Iterator;
import java.util.Map;

public class Reward {

    public Reward() {}

    public long sumTotalMatchPrice(Map<RewardTable, Long> map) {
        long totalRewardPrice = 0L;

        Iterator<RewardTable> keys = map.keySet().iterator();

        while (keys.hasNext()) {
            RewardTable key = keys.next();
            Long value = map.get(key);

            totalRewardPrice += sumMatchPrice(key, value);
        }

        return totalRewardPrice;
    }

    private Long sumMatchPrice(RewardTable key, Long value) {
        return key.getRewardByTimes(value);
    }
}
