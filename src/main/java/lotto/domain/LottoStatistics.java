package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public record LottoStatistics(Map<LottoRank, Integer> statistics) {

    public LottoStatistics {
        statistics = Map.copyOf(statistics);
    }

    public int getCount(LottoRank rank) {
        return statistics.getOrDefault(rank, 0);
    }

    public static LottoStatistics calculateStatistics(Lottos lottoList, WinningLotto winningLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottoList.lottos()) {
            LottoRank rank = lotto.rank(winningLotto);
            if (!rank.isNoRank()) {
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

    public float calculateYield(BigDecimal purchaseAmount) {
        return (float) totalPrize() / purchaseAmount.intValue();
    }
}
