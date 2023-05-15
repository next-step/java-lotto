package lotto.view;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private static final Map<Integer, Integer> PRIZE_MAP = new HashMap<>();

    static {
        PRIZE_MAP.put(6, 2000000000);
        PRIZE_MAP.put(5, 1500000);
        PRIZE_MAP.put(4, 50000);
        PRIZE_MAP.put(3, 5000);
        PRIZE_MAP.put(0, 0);
    }

    Prize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int calculatePrize(int matchCount) {
        return PRIZE_MAP.getOrDefault(matchCount, PRIZE_MAP.get(0));
    }

}
