package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResult {

    private final Map<Rank, Long> lottoMatchCountMap;
    private final int totalPrice;

    public LottoMatchResult(Map<Rank, Long> map, int totalPrice) {
        this.lottoMatchCountMap = map;
        this.totalPrice = totalPrice;
    }

    public long get(Rank rank) {
        return lottoMatchCountMap.getOrDefault(rank, 0L);
    }

    public double computeProfitRate() {
        long sum = lottoMatchCountMap.keySet().stream()
            .map(this::computeMatchAmount)
            .collect(Collectors.summingLong(Long::longValue));

        return 1.0 * sum / totalPrice;
    }

    private Long computeMatchAmount(Rank rank) {
        return rank.getWinningMoney() * lottoMatchCountMap.get(rank);
    }
}
