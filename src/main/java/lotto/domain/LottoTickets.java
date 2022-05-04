package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private final List<LottoTicket> lottoTickets;

  public LottoTickets(List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public LottoStatistics getResultStatistics(LottoTicket winLottoTicket) {
    List<LottoResult> lottoResults = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets) {
      lottoResults.add(lottoTicket.getWinLottoNumbers(winLottoTicket));
    }
    return new LottoStatistics(lottoResults);
  }

}
