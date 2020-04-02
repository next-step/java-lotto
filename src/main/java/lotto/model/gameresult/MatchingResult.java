package lotto.model.gameresult;

import lotto.model.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchingResult {
    private static Map<Rank, Integer> result = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public MatchingResult(Map<Rank, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public static Integer findRankCount(Rank rank) {
        return result.get(rank);
    }

    public static void increaseCount(Rank rank) {
        Integer integer = result.get(rank);
        result.replace(rank, integer + 1);
    }

    public static MatchingResult getInstance() {
        return new MatchingResult(result);
    }
}