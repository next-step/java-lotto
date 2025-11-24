package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final Map<Prize, Integer> prizeCounts;

    public LottoResults() {
        this(new HashMap<>());
    }

    public LottoResults(Map<Prize, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public void update(Prize prize) {
        prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
    }

    public long getPrizeValue() {
        return prizeCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * entry.getKey().value())
                .sum();
    }

    public double getReturnRate(PurchaseAmount purchaseAmount) {
        long totalPrize = getPrizeValue();
        return purchaseAmount.getReturnRate(totalPrize);
    }

    public Integer getPrizeCount(Prize prize) {
        return prizeCounts.getOrDefault(prize, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(prizeCounts, that.prizeCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prizeCounts);
    }
}
