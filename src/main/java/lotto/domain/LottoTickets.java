package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private List<LottoTicket> lottoTickets = new ArrayList<>();

  public int numberOfLottoTickets() {
    return lottoTickets.size();
  }

  public void updateLottoTickets(LottoTicket lottoTicket) {
    lottoTickets.add(lottoTicket);
  }
}
