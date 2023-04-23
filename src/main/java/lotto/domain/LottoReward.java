package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.*;

public enum LottoReward {
    NONE(-1, -1),
    MATCHED_3_NUMBERS(3, 5_000),
    MATCHED_4_NUMBERS(4, 50_000),
    MATCHED_5_NUMBERS(5, 1_500_000),
    MATCHED_6_NUMBERS(6, 2_000_000_000);

    private static final Map<Long, LottoReward> COUNT_MAP
            = Arrays.stream(values())
            .collect(toUnmodifiableMap(LottoReward::getMatchedCount, e -> e));

    private static final List<LottoReward> REWARD_VALUES
            = Arrays.stream(values())
            .sequential()
            .filter(not(LottoReward::isNone))
            .collect(toUnmodifiableList());

    private final long matchedCount;
    private final long reward;

    LottoReward(long matchedCount, long reward) {
        this.matchedCount = matchedCount;
        this.reward = reward;
    }

    public static Map<LottoReward, Integer> makeCountMap() {
        return Arrays.stream(values())
                .sequential()
                .collect(toMap(e -> e, e -> 0));
    }

    public static LottoReward findLottoReward(long matchedCount) {
        return COUNT_MAP.getOrDefault(matchedCount, NONE);
    }

    public static List<LottoReward> getRewardValues() {
        return REWARD_VALUES;
    }

    public long getMatchedCount() {
        return matchedCount;
    }

    public long getReward() {
        return reward;
    }

    public boolean isNone() {
        return NONE.equals(this);
    }
    
}