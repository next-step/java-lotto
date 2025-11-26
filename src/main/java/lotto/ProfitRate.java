package lotto;

public class ProfitRate {

  private final double value;

  public ProfitRate(LottoMatchResult matchResult, PurchaseAmount amount) {
    this.value = calculateProfitRate(calculateTotalPrize(matchResult), amount);
  }

  public double value() {
    return value;
  }

  private static long calculateTotalPrize(LottoMatchResult matchResult) {
    long totalPrize = 0;
    for (LottoRank rank : LottoRank.values()) {
      int count = matchResult.countMatches(rank.matchCount());
      totalPrize += (long) count * rank.prize();
    }
    return totalPrize;
  }

  private static double calculateProfitRate(long totalPrize, PurchaseAmount amount) {
    return (double) totalPrize / amount.value();
  }

}
