package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ETC(0, 0);

    private static final int NOT_WON = 0;
    private static final Map<Long, Prize> BY_MATCH_COUNT = new HashMap<>();

    static {
        for (Prize prize : values()) {
            BY_MATCH_COUNT.put(prize.matchCount, prize);
        }
    }

    private final long matchCount;
    private final int prize;

    private Prize(long matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Prize valueOfMatchCount(long matchCount) {
        return BY_MATCH_COUNT.get(matchCount >= Prize.FOURTH.matchCount ? matchCount : NOT_WON);
    }

    public int getPrize() {
        return prize;
    }
}
