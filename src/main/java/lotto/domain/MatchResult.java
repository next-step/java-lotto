package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private static final int DEFAULT_MATCH_COUNT = 0;
    private static final int COUNT = 1;

    private Map<Rank, Integer> result;

    private MatchResult() {
        result = new HashMap<>();
    }

    public static MatchResult getInstance() {
        return new MatchResult();
    }

    public void updateResult(Rank rank) {
        if (result.containsKey(rank)) {
            result.replace(rank, result.get(rank) + COUNT);
        }

        result.put(rank, COUNT);
    }

    public int getOrDefault(Rank rank) {
        return result.getOrDefault(rank, DEFAULT_MATCH_COUNT);
    }
}
