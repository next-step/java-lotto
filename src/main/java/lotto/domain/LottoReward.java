package lotto.domain;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toUnmodifiableMap;

public enum LottoReward {
    MATCHED_3_NUMBERS(3, 5_000),
    MATCHED_4_NUMBERS(4, 50_000),
    MATCHED_5_NUMBERS(5, 1_500_000),
    MATCHED_6_NUMBERS(6, 2_000_000_000);

    private static final Map<Long, LottoReward> COUNT_MAP
            = Arrays.stream(values())
            .collect(toUnmodifiableMap(LottoReward::getMatchedCount, e -> e));

    private final long matchedCount;
    private final long reward;

    LottoReward(long matchedCount, long reward) {
        this.matchedCount = matchedCount;
        this.reward = reward;
    }

    public static LottoReward findLottoReward(long matchedCount) {
        return COUNT_MAP.get(matchedCount);
    }

    public long getMatchedCount() {
        return matchedCount;
    }

    public long getReward() {
        return reward;
    }

}