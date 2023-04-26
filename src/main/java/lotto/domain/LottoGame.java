package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

  private final LottoTickets soldLottoTickets;
  private final LottoTicket winningLottoTicket;
  private final LottoNumber bonusNumber;

  public LottoGame(LottoTickets lottoTickets, LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
    this.soldLottoTickets = lottoTickets;
    this.winningLottoTicket = winningLottoTicket;
    this.bonusNumber = bonusNumber;
  }

  public LottoResult play() {
    List<LottoRank> lottoRanks = new ArrayList<>();

    for (LottoTicket lottoTicket : soldLottoTickets.unmodifiedLottoTickets()) {
      int matchedCount = lottoTicket.matchLottoCount(winningLottoTicket);
      boolean hasBonusNumber = lottoTicket.containsLottoNumbers(bonusNumber);

      lottoRanks.add(LottoRank.valueOfMatchedCount(matchedCount, hasBonusNumber));
    }

    return new LottoResult(lottoRanks);
  }
}
