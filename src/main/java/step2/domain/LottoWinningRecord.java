package step2.domain;

import java.util.Collections;
import java.util.Map;

public class LottoWinningRecord {
    private final Map<LottoRank, Integer> rankMap;

    public LottoWinningRecord(Map<LottoRank, Integer> rankMap) {
        this.rankMap = Collections.unmodifiableMap(rankMap);
    }

    public double totalLottoPrizeRatio(int totalSpent) {
        long totalPrize = rankMap.entrySet().stream()
                .mapToLong(e -> e.getKey().money() * e.getValue())
                .sum();
        return totalSpent == 0 ? 0 : (double) totalPrize / totalSpent;
    }

    public Map<LottoRank, Integer> rankMap() {
        return rankMap;
    }
}