package step2_2.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT_REWARD = 0;
    private static final long DEFAULT_WINNER = 0;

    private List<LottoReward> rewards;
    private Money money;

    public LottoResult(List<LottoReward> rewards, Money money) {
        this.rewards = rewards;
        this.money = money;
    }

    public double getYield() {
        int moneySum = getReward();
        return (double) moneySum / money.won();
    }

    private int getReward() {
        int rewardSum = DEFAULT_REWARD;
        for (LottoReward reward : rewards) {
            rewardSum += reward.getReward();
        }
        return rewardSum;
    }

    public Map<LottoReward, Long> getRewardMap() {
        Map<LottoReward, Long> rewardMap = initRewardMap();
        for (LottoReward reward : rewards) {
            long winners = rewardMap.get(reward);
            rewardMap.put(reward, winners + 1);
        }
        return Collections.unmodifiableMap(rewardMap);
    }

    private Map<LottoReward, Long> initRewardMap() {
        Map<LottoReward, Long> rewardMap = new HashMap<>();
        for (LottoReward lottoReward : LottoReward.values()) {
            rewardMap.put(lottoReward, DEFAULT_WINNER);
        }
        return rewardMap;
    }
}
