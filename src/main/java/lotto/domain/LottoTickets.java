package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private List<LottoTicket> tickets = new ArrayList<>();

  public LottoTickets(int buyLottoCount, List<LottoTicket> ticket) {
    tickets.addAll(ticket);

    int buyCount = buyLottoCount - tickets.size();
    createLotto(buyCount);
  }

  public LottoTickets getLottoTickets(int buyLottoCount) {
    createLotto(buyLottoCount);
    return this;
  }

  private void createLotto(int buyCount) {
    for (int i = 0; i < buyCount; i++) {
      tickets.add(new LottoCreator().create());
    }
  }

  public List<Rank> winNumberSize(List<Integer> winNumber, int bonusNumber) {
    List<Rank> ranks = new ArrayList<>();
    for (LottoTicket lottoTicket : tickets) {
      ranks.add(lottoTicket.winNumberSize(winNumber, bonusNumber));
    }
    return ranks;
  }

  public List<LottoTicket> getTickets() {
    return tickets;
  }
}
