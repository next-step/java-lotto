package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

  private final LottoTickets soldLottoTickets;
  private final LottoTicket winningLottoTicket;

  public LottoGame(LottoTickets lottoTickets, LottoTicket winningLottoTicket) {
    this.soldLottoTickets = lottoTickets;
    this.winningLottoTicket = winningLottoTicket;
  }

  public LottoResult play() {
    List<LottoRank> lottoRanks = soldLottoTickets.matchesLottoTickets(winningLottoTicket).stream()
            .map(LottoRank::valueOfMatchedCount)
            .collect(Collectors.toList());

    return new LottoResult(lottoRanks);
  }
}
