package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoStatisticsResult {

    private static final int DEFAULT_COUNT_VALUE = 0;

    private final Map<LottoRank, Integer> countByRank;
    private final double profit;

    public LottoStatisticsResult(Map<LottoRank, Integer> countByRank) {
        this.countByRank = countByRank;
        this.profit = calculateProfit(countByRank);
    }

    public static LottoStatisticsResult from(List<LottoRank> ranks) {
        Map<LottoRank, Integer> countByRank = new HashMap<>();
        for (LottoRank rank : ranks) {
            countByRank.put(rank, countByRank.getOrDefault(rank, DEFAULT_COUNT_VALUE) + 1);
        }
        return new LottoStatisticsResult(countByRank);
    }

    private double calculateProfit(Map<LottoRank, Integer> countByRank) {
        int totalCount = 0;
        Money totalAmount = new Money(0);
        for (LottoRank rank : countByRank.keySet()) {
            int count = countByRank.get(rank);
            totalCount += count;
            totalAmount = totalAmount.plus(rank.getReward().multiply(count));
        }
        return totalCount > 0 ? totalAmount.divideBy(Lotto.PRICE.multiply(totalCount)) : 0;
    }

    public int getCountByRank(LottoRank rank) {
        return countByRank.getOrDefault(rank, DEFAULT_COUNT_VALUE);
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoStatisticsResult that = (LottoStatisticsResult) o;
        return Objects.equals(countByRank, that.countByRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countByRank);
    }

    @Override
    public String toString() {
        return "LottoStatisticsResult{" +
                "countByRank=" + countByRank +
                '}';
    }

}
