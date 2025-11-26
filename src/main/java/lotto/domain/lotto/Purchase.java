package lotto.domain.lotto;

public class Purchase {

  private final int manualCount;
  private final int autoCount;
  private final Money purchaseAmount;

  public Purchase(int manualCount, int totalCount, Money pricePerTicket) {
    validate(manualCount, totalCount);
    this.manualCount = manualCount;
    this.autoCount = totalCount - manualCount;
    this.purchaseAmount = pricePerTicket.multiply(totalCount);
  }

  private static void validate(int manualCount, int totalCount){
    if (manualCount > totalCount) {
      throw new IllegalArgumentException("수동 구매 수가 총 구매 가능 수를 초과합니다");
    }
  }

  public Money getPurchaseAmount() {
    return purchaseAmount;
  }

  public int getAutoCount() {
    return autoCount;
  }

  @Override
  public String toString() {
    return "수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.";
  }
}