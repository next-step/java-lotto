package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    ETC(0);

    private static final Map<Long, Prize> BY_MATCH_COUNT = new HashMap<>();

    static {
        for (Prize prize : values()) {
            BY_MATCH_COUNT.put(prize.matchCount, prize);
        }
    }

    private long matchCount;

    private Prize(long matchCount) {
        this.matchCount = matchCount;
    }

    public static Prize valueOfMatchCount(long matchCount) {
        return BY_MATCH_COUNT.get(matchCount >= Prize.FOURTH.matchCount ? matchCount : 0);
    }
}
