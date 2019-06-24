package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private final List<LottoTicket> lottoTickets;

  public LottoTickets(int count) {
    lottoTickets = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottoTickets.add(LottoCreator.create());
    }
  }

  public LottoTickets(List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public List<Rank> winNumberSize(List<Integer> winNumber) {
    List<Rank> ranks = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets) {
      ranks.add(lottoTicket.winNumberSize(winNumber));
    }
    return ranks;
  }
}
