package lotto.domain.game;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.Money;
import lotto.domain.result.GameResult;
import lotto.domain.lotto.Purchase;

public class LottoGame {

  private final LottoTicket winningTicket;

  public LottoGame(LottoTicket winningTicket) {
    this.winningTicket = winningTicket;
  }

  public GameResult check(Purchase purchase) {
    Money winningPrize = new Money(0);
    Map<Rank, Integer> ranks = new HashMap<>();
    for (LottoTicket ticket : purchase.getTickets()) {
      Rank rank = Rank.valueOf(winningTicket.countMatchingNumbers(ticket));
      ranks.compute(rank, (k, v) -> v == null ? 1 : v + 1);
      winningPrize = winningPrize.add(rank.getPrize());
    }

    return new GameResult(ranks, winningPrize, purchase.getPurchaseAmount());
  }
}