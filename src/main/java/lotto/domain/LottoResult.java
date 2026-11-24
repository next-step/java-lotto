package lotto.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int PROFIT_RATE_SCALE = 2;

    private final Map<Rank, Long> rankCounts;
    private final PurchaseAmount purchaseAmount;

    public LottoResult(List<Rank> ranks, PurchaseAmount purchaseAmount) {
        this.rankCounts = ranks.stream()
                .collect(groupingBy(rank -> rank, counting()));
        this.purchaseAmount = purchaseAmount;
    }

    public int getCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0L).intValue();
    }

    public long getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double getProfitRate() {
        return BigDecimal.valueOf(getTotalPrize())
                .divide(BigDecimal.valueOf(purchaseAmount.getSpentAmount()), PROFIT_RATE_SCALE, RoundingMode.DOWN)
                .doubleValue();
    }
}
