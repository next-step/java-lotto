package lotto;

public class ProfitRate {

  private final double value;

  public ProfitRate(long totalPrize, PurchaseAmount amount) {
    this.value = calculateProfitRate(totalPrize, amount);
  }

  public double value() {
    return value;
  }

  private static double calculateProfitRate(long totalPrize, PurchaseAmount amount) {
    return (double) totalPrize / amount.value();
  }

}
