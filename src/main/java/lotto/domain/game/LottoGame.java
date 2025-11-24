package lotto.domain.game;

import lotto.domain.lotto.Purchase;
import lotto.domain.lotto.WinningTicket;
import lotto.domain.result.GameResult;

public class LottoGame {

  private final WinningTicket winningTicket;

  public LottoGame(WinningTicket winningTicket) {
    this.winningTicket = winningTicket;
  }

  public GameResult check(Purchase purchase) {
    return new GameResult(purchase.matchWith(winningTicket));
  }

}