package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record LottoStatistics(Map<LottoRank, Integer> statistics) {

    public LottoStatistics {
        statistics = Map.copyOf(statistics);
    }

    public int getCount(LottoRank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    static LottoStatistics calculateStatistics(Lottos lottoList, Lotto winningLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottoList.lottos()) {
            int matchCount = lotto.matchCount(winningLotto);
            LottoRank rank = LottoRank.fromMatchCount(matchCount);
            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return new LottoStatistics(result);
    }

    long totalPrize() {
        return statistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prizeMoney() * entry.getValue())
                .sum();
    }

    float calculateYield(BigDecimal purchaseAmount) {
        return (float) totalPrize() / purchaseAmount.intValue();
    }
}
