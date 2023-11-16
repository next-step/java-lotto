package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private Map<Integer, Integer> matchResult = new HashMap<>();

    public void storeResult(int matchCount) {
        matchResult.put(matchCount, matchResult.getOrDefault(matchCount, 0) + 1);
    }

    public Map<Integer, Integer> getAllResult() {
        return matchResult;
    }

    public long getPrizeSum() {
        return 0;
    }

}
