package lotto.common;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrizeMoney {

    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L);

    private final int matchNumberCount;
    private final long prizeMoney;

    private static final Map<Integer, LottoPrizeMoney> map = new HashMap<Integer, LottoPrizeMoney>() {{
        put(3, THREE);
        put(4, FOUR);
        put(5, FIVE);
        put(6, SIX);
    }};

    LottoPrizeMoney(int matchNumberCount, long prizeMoney) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrizeMoney find(int matchNumberCount) {
        return map.get(matchNumberCount);
    }
}
