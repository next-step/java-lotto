package lotto;

import java.util.Map;

public class ProfitRate {

  private final double value;

  public ProfitRate(Map<Integer, Integer> matchCounts, PurchaseAmount amount) {
    this.value = calculateProfitRate(calculateTotalPrize(matchCounts), amount);
  }

  public double value() {
    return value;
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
