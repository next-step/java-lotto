package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoRankCounter {
    private final Map<LottoRank, Integer> countFinder = new HashMap<>();

    public void addCount(LottoRank rank) {
        int previousCount = countFinder.getOrDefault(rank, 0);
        int nextCount = previousCount + 1;
        countFinder.put(rank, nextCount);
    }

    public int getCount(LottoRank rank) {
        return countFinder.getOrDefault(rank, 0);
    }
}
