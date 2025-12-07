package lotto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record LottoStatistics(Map<LottoRank, Integer> statistics) {

    static Map<LottoRank, Integer> calculateStatistics(List<Lotto> lottoList, Lotto winningLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(winningLotto);
            LottoRank rank = LottoRank.fromMatchCount(matchCount);
            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return result;
    }

    static float calculateYield(Map<LottoRank, Integer> statistics, BigDecimal purchaseAmount) {
        long totalPrize = statistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prizeMoney() * entry.getValue())
                .sum();

        return (float) totalPrize / purchaseAmount.intValue();
    }
}
