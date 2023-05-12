package step2.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    private static final Map<Integer, LottoRank> BY_MATCH_COUNT =
            Arrays.stream(values()).collect(Collectors.toMap(LottoRank::getMatchCount, Function.identity()));

    private static final int MIN_MATCH_COUNT = 3;

    public static LottoRank valueOf(int matchedCount) {
        if (matchedCount < MIN_MATCH_COUNT) {
            return MISS;
        }
        return BY_MATCH_COUNT.get(matchedCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}


