package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> matchCountMap;

    public LottoResult() {
        matchCountMap = new HashMap<>();
    }

    public int increaseMatchCount(int matchCount) {
        if (matchCountMap.containsKey(matchCount) == false) {
            matchCountMap.put(matchCount, 0);
        }
        int currentMatchCount = matchCountMap.get(matchCount) + 1;
        matchCountMap.put(matchCount, currentMatchCount);
        return 0;
    }

    public int getMatchCount(int matchCount) {
        try {
            return matchCountMap.get(matchCount);
        } catch (Exception e) {
            return 0;
        }
    }
}
