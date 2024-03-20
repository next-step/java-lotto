package lotto.domain;

public class LottoTickets {

  private PurchaseAmount purchaseAmount;

  public LottoTickets(int amount) {
    this.purchaseAmount = new PurchaseAmount(amount);
  }

  public int ticketCount() {
    return this.purchaseAmount.ticketCount();
  }

  public boolean isSamePurchaseAmount(int amount) {
    return this.purchaseAmount.isSame(amount);
  }
}
