package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private static final int TOTAL_ZERO = 0;

    private final Map<Integer, Integer> matchesTotalMap;

    private MatchResult(Map<Integer, Integer> matchesTotalMap) {
        this.matchesTotalMap = Collections.unmodifiableMap(Objects.requireNonNull(matchesTotalMap));
    }

    public static MatchResult of(Map<Integer, Integer> matchesTotalMap) {
        return new MatchResult(matchesTotalMap);
    }

    public int getTotalMatches(int matches) {
        return matchesTotalMap.getOrDefault(matches, TOTAL_ZERO);
    }
}
