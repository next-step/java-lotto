package lotto.domain.lotto;

import java.util.List;

public class Purchase {

  private final Money pricePerTicket;
  private final List<LottoTicket> tickets;

  public Purchase(Money pricePerTicket, List<LottoTicket> tickets) {
    this.pricePerTicket = pricePerTicket;
    this.tickets = tickets;
  }

  public List<LottoTicket> getTickets() {
    return this.tickets;
  }

  public Money getPurchaseAmount() {
    return this.pricePerTicket.multiply(this.tickets.size());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(tickets.size()).append("개를 구매했습니다.\n");
    for (int i = 0; i < tickets.size(); i++) {
      sb.append(tickets.get(i) + "\n");
    }
    return sb.toString();
  }
}