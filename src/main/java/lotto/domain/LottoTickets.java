package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private List<LottoTicket> tickets = new ArrayList<>();

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = tickets;
  }

  private LottoTickets(int buyLottoCount, LottoTickets ticket) {
    createLotto(buyLottoCount - ticket.size());
    tickets.addAll(ticket.getTickets());
  }

  public static LottoTickets of(int buyLottoCount, LottoTickets ticket) {
    return new LottoTickets(buyLottoCount, ticket);
  }

  public static LottoTickets of(List<LottoTicket> tickets) {
    return new LottoTickets(tickets);
  }

  private void createLotto(int buyCount) {
    for (int i = 0; i < buyCount; i++) {
      tickets.add(new LottoCreator().create());
    }
  }

  public List<Rank> winNumberSize(WinNumber winNumber) {
    List<Rank> ranks = new ArrayList<>();
    for (LottoTicket lottoTicket : tickets) {
      ranks.add(lottoTicket.winNumberSize(winNumber));
    }
    return ranks;
  }

  public List<LottoTicket> getTickets() {
    return tickets;
  }

  private int size() {
    return tickets.size();
  }

  @Override
  public String toString() {
    return tickets.toString();
  }
}
