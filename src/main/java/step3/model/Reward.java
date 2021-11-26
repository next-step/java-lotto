package step3.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Reward implements Comparable<Reward> {
    FIRST(6, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BANG(0, 0);

    private static final long DEFAULT_WINNER_COUNT = 0L;

    private final long matchCount;
    private final Money rewardMoney;

    Reward(long matchCount, long rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = new Money(rewardMoney);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public Money getRewardMoney() {
        return rewardMoney;
    }

    public static Reward of(long matchCount, boolean isBonusMatch) {
        Reward reward = fromMatchCount(matchCount);
        if (reward.equals(THIRD) && isBonusMatch) {
            return SECOND;
        }
        return reward;
    }

    private static Reward fromMatchCount(long matchCount) {
        return Arrays.stream(values())
            .filter(reward -> reward.getMatchCount() == matchCount)
            .findAny()
            .orElse(BANG);
    }

    public static Map<Reward, Long> getDefaultRewardMap() {
        Map<Reward, Long> defaultRewardMap = new HashMap<>();
        Arrays.stream(values())
            .forEach(reward -> defaultRewardMap.put(reward, DEFAULT_WINNER_COUNT));
        return defaultRewardMap;
    }

    public boolean isWin() {
        return this != BANG;
    }
}
