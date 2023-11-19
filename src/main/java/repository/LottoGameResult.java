package repository;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {
    private Map<Integer, Integer> matchResult = new HashMap<>();

    public void saveResult(int matchCount) {
        matchResult.put(matchCount, matchResult.getOrDefault(matchCount, 0) + 1);
    }

    public Map<Integer, Integer> getAllResult() {
        return matchResult;
    }

    public void clearStore(){
        matchResult.clear();
    }

}
