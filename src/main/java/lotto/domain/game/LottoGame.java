package lotto.domain.game;

import java.util.List;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.Purchase;
import lotto.domain.lotto.WinningTicket;
import lotto.domain.result.GameResult;

public class LottoGame {

  private final WinningTicket winningTicket;

  public LottoGame(WinningTicket winningTicket) {
    this.winningTicket = winningTicket;
  }

  public GameResult check(Purchase purchase) {
    LottoTickets tickets = purchase.getTickets();
    return tickets.updateRank(winningTicket);
  }

}