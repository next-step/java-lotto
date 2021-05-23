package com.lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoStatistics {
    private Map<LottoReward, Integer> lottoStatistics;

    private LottoStatistics(Map<LottoReward, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public static LottoStatistics createLottoStatistics(List<LottoReward> lottoRewards) {
        Map<LottoReward, Integer> map = new HashMap<>();

        for (LottoReward reward : lottoRewards) {
            map.put(reward, map.get(reward) != null ? map.get(reward) + 1 : 1);
        }

        return new LottoStatistics(map);
    }

    public Set<LottoReward> keySet() {
        return this.lottoStatistics.keySet();
    }

    public Integer get(LottoReward reward) {
        if (this.lottoStatistics.get(reward) == null) {
            return 0;
        }

        return this.lottoStatistics.get(reward);
    }

    public int totalReward() {
        int totalReward = 0;
        for (LottoReward reward : lottoStatistics.keySet()) {
            totalReward += reward.totalReward(lottoStatistics.get(reward));
        }

        return totalReward;
    }

    public double yield() {
        int totalCount = 0;
        for (Integer count : lottoStatistics.values()) {
            totalCount += count;
        }

        int investment = totalCount * Lotto.UNIT_PRICE;

        return totalReward() / investment;
    }

    public int size() {
        return this.lottoStatistics.size();
    }
}
