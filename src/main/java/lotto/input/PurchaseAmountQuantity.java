package lotto.input;

import lotto.domain.MatchNumberCount;
import lotto.domain.LottoRoi;

public final class PurchaseAmountQuantity {

  private final int amount;
  private final int quantity;

  public PurchaseAmountQuantity(int amount) {
    this.amount = amount;
    this.quantity = amount / 1000;
    System.out.println(quantity + "개를 구매했습니다.");
  }

  public int getQuantity() {
    return quantity;
  }

  public LottoRoi getRoiBy(MatchNumberCount matchNumberCount) {
    return new LottoRoi(
        Math.floor((double) matchNumberCount.getRevenue() / this.amount * 100) / 100.0
    );
  }
}
