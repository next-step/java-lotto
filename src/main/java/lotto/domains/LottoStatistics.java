package lotto.domains;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private static final int MIN_MATCH_COUNT = 0;
    private static final int MAX_MATCH_COUNT = 6;

    private final Map<Integer, LottoStatistic> statisticsMap = new HashMap<>();

    public LottoStatistics() {
        for (int matchCount = MIN_MATCH_COUNT; matchCount <= MAX_MATCH_COUNT; matchCount++) {
            statisticsMap.put(matchCount, new LottoStatistic());
        }
    }

    public int count(int key) {
        return statisticsMap.get(key).count();
    }

    public void add(int key) {
        statisticsMap.get(key).add(key);
    }

    public int totalPayout() {
        return statisticsMap.values()
                .stream()
                .mapToInt(LottoStatistic::payout)
                .sum();
    }
}
