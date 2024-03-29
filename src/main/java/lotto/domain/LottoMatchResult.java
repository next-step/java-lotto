package lotto.domain;

import java.util.HashMap;

public class LottoMatchResult {
    private static final HashMap<Rank, Integer> matchResult = new HashMap<>() {{
        put(Rank.FIRST, 0);
        put(Rank.SECOND, 0);
        put(Rank.THIRD, 0);
        put(Rank.FOURTH, 0);
        put(Rank.FIFTH, 0);
    }};

    public static void putMatchResult(Rank rank) {
        if (rank == Rank.NONE) {
            return;
        }
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }

    public static HashMap<Rank, Integer> getMatchResult() {
        return matchResult;
    }
}
