package lotto.common;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPrizeMoney {

    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    SIX(6, 2000_000_000L);

    private final int matchNumberCount;
    private final long prizeMoney;

    private static final Map<Integer, LottoPrizeMoney> MAP;

    static {
        MAP = Arrays.stream(LottoPrizeMoney.values())
            .collect(Collectors.toMap(e -> e.matchNumberCount, e -> e));
    }

    LottoPrizeMoney(int matchNumberCount, long prizeMoney) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public static long findByMatchNumberCount(int matchNumberCount) {
        return MAP.get(matchNumberCount).prizeMoney;
    }
}
