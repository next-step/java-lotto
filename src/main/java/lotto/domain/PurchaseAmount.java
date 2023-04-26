package lotto.domain;

public class PurchaseAmount {
  private final int amount;

  public PurchaseAmount(int amount) {
    this.amount = amount;
  }

  public int getTicketCount() {
    return amount / LottoTicket.TICKET_PRICE;
  }
}
