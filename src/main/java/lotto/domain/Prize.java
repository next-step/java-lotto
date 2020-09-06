package lotto.domain;

import java.util.*;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ETC(0, 0);

    private static final Map<Long, Prize> BY_MATCH_COUNT = new HashMap<>();

    static {
        for (Prize prize : values()) {
            BY_MATCH_COUNT.put(prize.matchCount, prize);
        }
    }

    private final long matchCount;
    private final int reward;

    private Prize(long matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Prize valueOfMatchCount(long matchCount) {
        return BY_MATCH_COUNT.get(matchCount >= Prize.FOURTH.matchCount ? matchCount : 0);
    }

    public static List<Prize> valuesOfWin() {
        return Arrays.asList(Prize.FOURTH, Prize.THIRD, Prize.SECOND, Prize.FIRST);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
