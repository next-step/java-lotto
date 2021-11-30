package lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

public class Result {

    private static final int INIT_COUNT = 0;
    private static final int PLUS_COUNT = 1;

    private final Map<Rank, Integer> ranks;

    public Result() {
        ranks = initMatchedCounts();
    }

    private Map<Rank, Integer> initMatchedCounts() {
        final Map<Rank, Integer> matchedCounts;
        matchedCounts = new TreeMap<>();
        matchedCounts.put(Rank.FIRST, INIT_COUNT);
        matchedCounts.put(Rank.SECOND, INIT_COUNT);
        matchedCounts.put(Rank.THIRD, INIT_COUNT);
        matchedCounts.put(Rank.FOURTH, INIT_COUNT);
        matchedCounts.put(Rank.FIFTH, INIT_COUNT);
        return matchedCounts;
    }

    public Result add(Rank rank) {
        ranks.merge(rank, PLUS_COUNT, (first, second) -> first + second);
        return this;
    }

    public Money calculateWinningAmount() {
        return new Money(ranks.entrySet()
                              .stream()
                              .mapToInt(calculateEachWinningAmount())
                              .sum());
    }

    private ToIntFunction<Entry<Rank, Integer>> calculateEachWinningAmount() {
        return entry -> {
            Rank rank = entry.getKey();
            Integer matchedCount = entry.getValue();
            return rank.getPrice() * matchedCount;
        };
    }

    public Map<Rank, Integer> getRanks() {
        return Collections.unmodifiableMap(((TreeMap) ranks).descendingMap());
    }
}
