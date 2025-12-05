package lotto;

public class ManualLottoCount {

  private final int count;

  public ManualLottoCount(int count, int purchaseAmount) {
    this(count, new PurchaseAmount(purchaseAmount));
  }

  public ManualLottoCount(int count, PurchaseAmount amount) {
    if (amount.ticketCount() < count) {
      throw new IllegalArgumentException("수동 장수는 구입 가능한 수량을 초과할 수 없습니다.");
    }
    this.count = count;
  }

  public int count() {
    return count;
  }
}
