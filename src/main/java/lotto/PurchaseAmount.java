package lotto;

public class PurchaseAmount {
  private final int money;

  public PurchaseAmount(int money) {
    this.money = money;
  }

  public int getTicketCount() {
    return money / LottoTicket.PRICE;
  }

  public float calculateRateOfReturn(int totalPrize) {
    return (float) totalPrize / money;
  }
}
