package lotto.domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.game.Rank;

public class Purchase {

  private final Money pricePerTicket;
  private final List<LottoTicket> tickets;

  public Purchase(Money pricePerTicket, List<LottoTicket> tickets) {
    this.pricePerTicket = pricePerTicket;
    this.tickets = List.copyOf(tickets);
  }

  public Map<Rank, Integer> matchWith(WinningTicket winningTicket) {
    Map<Rank, Integer> ranks = new HashMap<>();
    for (LottoTicket ticket : tickets) {
      ranks.compute(winningTicket.match(ticket), (k, v) -> v == null ? 1 : v + 1);
    }
    return ranks;
  }

  public int getTicketCount() {
    return tickets.size();
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