package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Match, Integer> matchedCounts;

    public Result() {
        matchedCounts = new HashMap<>();
        matchedCounts.put(Match.THREE, 0);
        matchedCounts.put(Match.FOUR, 0);
        matchedCounts.put(Match.FIVE, 0);
        matchedCounts.put(Match.SIX, 0);
    }

    public Result add(int matchCount) {
        matchedCounts.merge(Match.from(matchCount), 1, (first, second) -> first + second);
        return this;
    }

    public int winningAmount() {
        return matchedCounts.entrySet()
                            .stream()
                            .mapToInt(entry -> entry.getKey().winningAmount(entry.getValue()))
                            .sum();
    }
}
