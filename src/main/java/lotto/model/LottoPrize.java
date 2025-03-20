package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int amount;
    private static final Map<Integer, LottoPrize> map = new HashMap<>();

    LottoPrize(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    static {
        for (LottoPrize prize : LottoPrize.values()) {
            map.put(prize.matchCount, prize);
        }
    }

    public int getAmount() {
        return amount;
    }

    public static LottoPrize valueOf(int matchCount) {
        return map.getOrDefault(matchCount, NONE);
    }
}
