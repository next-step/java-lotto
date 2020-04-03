package lotto.model.gameresult;

import lotto.model.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private static final int ONE_MORE_COUNT= 1;

    private Map<Rank, Integer> results;

    private Results(Map<Rank, Integer> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public static Results reflectAll(List<Rank> ranks) {
        Map<Rank, Integer> results = setUp();
        ranks.stream()
                .forEach(it -> reflect(results, it));
        return new Results(results);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    private static Map<Rank, Integer> setUp() {
        Map<Rank, Integer> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        return result;
    }

    private static void reflect(Map<Rank, Integer> results, Rank rank) {
        Integer currentCount = results.get(rank);
        results.replace(rank, currentCount + ONE_MORE_COUNT);
    }
}
