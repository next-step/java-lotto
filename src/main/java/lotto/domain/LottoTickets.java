package lotto.domain;

import java.util.List;

public class LottoTickets {

  private final PurchaseAmount purchaseAmount;
  private final List<LottoTicket> tickets;

  public LottoTickets(int amount) {
    this.purchaseAmount = new PurchaseAmount(amount);
    this.tickets = LottoTicket.generate(this.purchaseAmount.ticketCount());
  }

  public int ticketCount() {
    return this.purchaseAmount.ticketCount();
  }

  public boolean isSamePurchaseAmount(int amount) {
    return this.purchaseAmount.isSame(amount);
  }

  public boolean haveAll6Numbers() {
    return this.tickets.stream()
        .allMatch(ticket -> ticket.size() == 6);
  }

  public boolean haveCorrectNumbers() {
    return this.tickets.stream()
        .allMatch(LottoTicket::haveCorrectNumbers);
  }
}
