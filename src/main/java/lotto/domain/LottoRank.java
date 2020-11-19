package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private static final Map<Integer, LottoRank> RANK_MATCH_COUNT_MAP = Collections.unmodifiableMap(
            Arrays.stream(LottoRank.values()).collect(
                    Collectors.toMap(value -> value.matchCount, Function.identity())));

    private int matchCount;
    private int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank of(int count) {
        if (Objects.isNull(RANK_MATCH_COUNT_MAP.get(count))) {
            return LottoRank.NONE;
        }
        return RANK_MATCH_COUNT_MAP.get(count);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }
}
