package autolotto.domain;

import autolotto.constant.Rank;

import java.util.*;

public class Results {
    private final Map<Rank, Integer> results = new LinkedHashMap<>();

    public int plusWinners(Rank rank) {
        int winners = results.getOrDefault(rank, 0);
        results.put(rank, ++winners);
        return winners;
    }

    public int countOfWinners(Rank rank) {
        return results.getOrDefault(rank, 0);
    }
}
