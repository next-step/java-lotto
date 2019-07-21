package lotto;

import java.util.HashMap;
import java.util.Map;

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

    public int getTotalLottoMoneyAt(LottoRank rank) {
        int count = getCount(rank);
        return rank.getWinningMoney() * count;
    }

    public int getTotalLottoMoney() {
        return countFinder.keySet().stream()
                          .mapToInt(this::getTotalLottoMoneyAt)
                          .sum();
    }

    public int size() {
        return countFinder.values()
                          .stream()
                          .mapToInt(Integer::intValue)
                          .sum();
    }
}
