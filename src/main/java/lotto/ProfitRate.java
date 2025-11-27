package lotto;

public class ProfitRate {

  private final double value;

  public ProfitRate(LottoMatchResult matchResult, PurchaseAmount amount) {
    this.value = calculateProfitRate(matchResult.totalPrize(), amount);
  }

  public double value() {
    return value;
  }

  private static double calculateProfitRate(long totalPrize, PurchaseAmount amount) {
    return (double) totalPrize / amount.value();
  }

}
