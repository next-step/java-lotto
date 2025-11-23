package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {
    private final Map<Integer, Integer> matchCounts;

    public LottoResults() {
        this(new HashMap<>());
    }

    public LottoResults(Map<Integer, Integer> matchCounts) {
        this.matchCounts = matchCounts;
    }

    public void updateMatchCount(int matchCount) {
        if (matchCount < 3) {
            return;
        }
        matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0) + 1);
    }

    public long getPrizeValue() {
        return matchCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getValue() * Prize.fromMatchCount(entry.getKey()).value())
                .sum();
    }

    public double getReturnRate(PurchaseAmount purchaseAmount) {
        long totalPrize = getPrizeValue();
        return purchaseAmount.getReturnRate(totalPrize);
    }

    public Integer getMatchCount(int matchCount) {
        return matchCounts.getOrDefault(matchCount, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(matchCounts, that.matchCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchCounts);
    }

    @Override
    public String toString() {
        return "LottoResults{" +
                "matchCounts=" + matchCounts +
                '}';
    }
}
