package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

public class Result {

    private static final int MIN_WINNING_COUNT = 3;
    private static final int INIT_COUNT = 0;
    private static final int PLUS_COUNT = 1;
    private static final int DECIMAL_DENOMINATOR = 100;
    private static final double DECIMAL_NUMERATOR = 100.0;

    private final Map<Match, Integer> matchedCounts;

    public Result() {
        matchedCounts = initMatchedCounts();
    }

    private Map<Match, Integer> initMatchedCounts() {
        final Map<Match, Integer> matchedCounts;
        matchedCounts = new TreeMap<>();
        matchedCounts.put(Match.THREE, INIT_COUNT);
        matchedCounts.put(Match.FOUR, INIT_COUNT);
        matchedCounts.put(Match.FIVE, INIT_COUNT);
        matchedCounts.put(Match.SIX, INIT_COUNT);
        return matchedCounts;
    }

    public Result add(int matchCount) {
        if (matchCount < MIN_WINNING_COUNT) {
            return this;
        }
        matchedCounts.merge(Match.from(matchCount), PLUS_COUNT, (first, second) -> first + second);
        return this;
    }

    public int calculateWinningAmount() {
        return matchedCounts.entrySet()
                            .stream()
                            .mapToInt(calculateEachWinningAmount())
                            .sum();
    }

    private ToIntFunction<Entry<Match, Integer>> calculateEachWinningAmount() {
        return entry -> {
            Match match = entry.getKey();
            Integer matchedCount = entry.getValue();
            return match.getPrice() * matchedCount;
        };
    }

    public Double calculateRatio(int purchasedAmount) {
        return Math.floor(calculateWinningAmount() / (double) purchasedAmount * DECIMAL_DENOMINATOR) / DECIMAL_NUMERATOR;
    }

    public Map<Match, Integer> matchResult() {
        return Collections.unmodifiableMap(matchedCounts);
    }
}
