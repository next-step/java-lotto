package step3.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoReward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BANG(0, 0);

    private static final long DEFAULT_WINNER_COUNT = 0L;

    private final long matchCount;
    private final Money reward;

    LottoReward(long matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = new Money(reward);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public Money getReward() {
        return reward;
    }

    public static LottoReward of(long matchCount, boolean isBonusMatch) {
        LottoReward lottoReward = fromMatchCount(matchCount);
        if (lottoReward.equals(THIRD) && isBonusMatch) {
            return SECOND;
        }
        return lottoReward;
    }

    private static LottoReward fromMatchCount(long matchCount) {
        return Arrays.stream(values())
            .filter(lottoReward -> lottoReward.getMatchCount() == matchCount)
            .findAny()
            .orElse(BANG);
    }

    public static Map<LottoReward, Long> getDefaultRewardMap() {
        Map<LottoReward, Long> defaultRewardMap = new HashMap<>();
        Arrays.stream(values())
            .forEach(lottoReward -> defaultRewardMap.put(lottoReward, DEFAULT_WINNER_COUNT));
        return defaultRewardMap;
    }
}
