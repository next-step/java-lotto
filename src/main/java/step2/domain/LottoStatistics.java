package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private static final Map<Integer, Integer> PRIZE_MONEY_MAP;
    private static final Map<Integer, Integer> MATCH_COUNT_MAP;

    static {
        PRIZE_MONEY_MAP = new HashMap<>();
        PRIZE_MONEY_MAP.put(3, 5000);
        PRIZE_MONEY_MAP.put(4, 50000);
        PRIZE_MONEY_MAP.put(5, 1500000);
        PRIZE_MONEY_MAP.put(6, 2000000000);

        MATCH_COUNT_MAP = new HashMap<>();
        for (int i = 0; i <= 6; i++) {
            MATCH_COUNT_MAP.put(i, 0);
        }
    }

    public void incrementMatchCount(int matchCount) {
        validateMatchCount(matchCount);
        MATCH_COUNT_MAP.put(matchCount, MATCH_COUNT_MAP.get(matchCount) + 1);
    }

    public int getPrizeMoney(int matchCount) {
        return PRIZE_MONEY_MAP.getOrDefault(matchCount, 0);
    }

    public int getCountByMatchCount(int matchCount) {
        return MATCH_COUNT_MAP.getOrDefault(matchCount, 0);
    }

    public int getPrizeMoneyByMatchCount(int matchCount) {
        return PRIZE_MONEY_MAP.getOrDefault(matchCount, 0);
    }

    public int getEarningsByMatchCount(int matchCount) {
        return getPrizeMoney(matchCount) * getCountByMatchCount(matchCount);
    }

    private void validateMatchCount(int matchCount) {
        if (!MATCH_COUNT_MAP.containsKey(matchCount)) {
            throw new IllegalArgumentException("유효하지 않은 매치 수: " + matchCount);
        }
    }
}
