package lotto;

public class ManualLottoCount {

  private final int count;

  public ManualLottoCount(int count, int purchaseAmount) {
    this(count, new PurchaseAmount(purchaseAmount));
  }

  public ManualLottoCount(int count, PurchaseAmount amount) {
    validateNonNegativeCount(count);
    validateNotExceedPurchaseAmount(count, amount);
    this.count = count;
  }

  public int count() {
    return count;
  }

  private static void validateNonNegativeCount(int count) {
    if (count < 0) {
      throw new IllegalArgumentException("수동 로또 수량은 0 이상이어야 합니다.");
    }
  }

  private static void validateNotExceedPurchaseAmount(int count, PurchaseAmount amount) {
    if (amount.ticketCount() < count) {
      throw new IllegalArgumentException("수동 장수는 구입 가능한 수량을 초과할 수 없습니다.");
    }
  }

}
