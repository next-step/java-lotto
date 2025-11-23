package lotto.domain.game;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.WinningLottoTicket;
import lotto.domain.result.GameResult;
import lotto.domain.result.ProfitRate;
import lotto.domain.result.Purchase;
import lotto.domain.result.Statistics;

public class LottoGame {

  private final WinningLottoTicket winningTicket;

  public LottoGame(WinningLottoTicket winningTicket) {
    this.winningTicket = winningTicket;
  }

  public GameResult check(Purchase purchase) {
    int winningPrize = 0;
    Map<Rank, Integer> ranks = new HashMap<>();
    for (LottoTicket ticket : purchase.getTickets()) {
      Rank rank = winningTicket.compare(ticket);
      ranks.compute(rank, (k, v) -> v == null ? 1 : v + 1);
      winningPrize += rank.getPrize();
    }

    Statistics statistics = new Statistics(ranks);
    ProfitRate rate = new ProfitRate(winningPrize, purchase.getPurchaseAmount());

    return new GameResult(statistics, rate);
  }
}