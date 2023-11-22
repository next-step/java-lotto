package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchNumbers {
    private static final int MAX_MATCH = 6;
    private static final int MIN_MATCH = 3;
    private static final int DEFAULT = 0;

    private static final String ERROR_OVER_MATCH_COUNT = "맞은 갯수는 최대 6개입니다.";
    private static final String ERROR_UNDER_MATCH_COUNT = "맞은 갯수는 최소 0개입니다.";

    private Map<Integer, Integer> matchNumberMap = new HashMap<>();

    public LottoMatchNumbers() {
        for (int i=MIN_MATCH; i<=MAX_MATCH; i++) {
            this.matchNumberMap.put(i, 0);
        }
    }

    public void put(int matchCount) {
        if (matchCount > MAX_MATCH) {
            throw new IllegalArgumentException(ERROR_OVER_MATCH_COUNT);
        }
        if (matchCount < DEFAULT) {
            throw new IllegalArgumentException(ERROR_UNDER_MATCH_COUNT);
        }
        if (matchCount < MIN_MATCH) {
            return;
        }
        matchNumberMap.put(matchCount, matchNumberMap.get(matchCount)+1);
    }

    public Map<Integer, Integer> getMatchNumberMap() {
        return matchNumberMap;
    }
}
