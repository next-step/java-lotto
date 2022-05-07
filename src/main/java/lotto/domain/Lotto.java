package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

  private final List<LottoTicket> lottoTickets;

  public Lotto(List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public LottoResult result(WinLotto winLotto) {
    List<LottoRank> lottoRanks = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets) {
      lottoRanks.add(lottoTicket.getWinLottoNumbers(winLotto));
    }
    return new LottoResult(lottoRanks);
  }

  public List<LottoTicket> getLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

}
