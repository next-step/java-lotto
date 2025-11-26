package lotto;

import java.util.Map;

public class LottoResult {

  private final Map<Integer, Integer> matchCounts;
  private final double profitRate;

  public LottoResult(Map<Integer, Integer> matchCounts, PurchaseAmount amount) {
    this.matchCounts = matchCounts;
    this.profitRate = calculateProfitRate(calculateTotalPrize(matchCounts), amount);
  }

  public Map<Integer, Integer> matchCounts() {
    return matchCounts;
  }

  public double profitRate() {
    return profitRate;
  }

  private static long calculateTotalPrize(Map<Integer, Integer> result) {
    long totalPrize = 0;
    for (LottoRank rank : LottoRank.values()) {
      int count = result.getOrDefault(rank.matchCount(), 0);
      totalPrize += (long) count * rank.prize();
    }
    return totalPrize;
  }

  private static double calculateProfitRate(long totalPrize, PurchaseAmount amount) {
    return (double) totalPrize / amount.value();
  }
}
