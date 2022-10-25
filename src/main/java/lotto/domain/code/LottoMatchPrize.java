package lotto.domain.code;

import java.util.HashMap;
import java.util.Map;

public enum LottoMatchPrize {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int money;
    private static final Map<Integer, LottoMatchPrize> MATCH_COUNT_MAP = new HashMap<>();
    static {
        for (LottoMatchPrize value : LottoMatchPrize.values()) {
            MATCH_COUNT_MAP.put(value.matchCount, value);
        }
    }

    LottoMatchPrize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoMatchPrize getBy(int matchCount) {
        return MATCH_COUNT_MAP.get(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
