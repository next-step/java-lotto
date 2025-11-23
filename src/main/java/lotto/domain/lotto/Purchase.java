package lotto.domain.lotto;

import java.util.List;

public class Purchase {

  private final int pricePerTicket;
  private final List<LottoTicket> tickets;

  public Purchase(int pricePerTicket, List<LottoTicket> tickets) {
    this.pricePerTicket = pricePerTicket;
    this.tickets = tickets;
  }

  public List<LottoTicket> getTickets() {
    return this.tickets;
  }

  public int getPurchaseAmount() {
    return this.pricePerTicket * this.tickets.size();
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