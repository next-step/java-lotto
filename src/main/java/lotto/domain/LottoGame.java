package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

  private final LottoTickets soldLottoTickets;

  private final WinningTicket winningTicket;

  public LottoGame(LottoTickets lottoTickets, LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
    this.soldLottoTickets = lottoTickets;
    this.winningTicket = new WinningTicket(winningLottoTicket, bonusNumber);
  }

  public LottoResult play() {
    List<LottoRank> lottoRanks = new ArrayList<>();

    for (LottoTicket lottoTicket : soldLottoTickets.unmodifiedLottoTickets()) {
      int matchedCount = winningTicket.matchLottoCount(lottoTicket);
      boolean hasBonusNumber = winningTicket.containsBonusNumber(lottoTicket);

      lottoRanks.add(LottoRank.valueOfMatchedCount(matchedCount, hasBonusNumber));
    }

    return new LottoResult(lottoRanks);
  }
}
