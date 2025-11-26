package lotto.domain.lotto;

import java.util.List;
import lotto.domain.result.GameResult;

public class LottoTickets {
  private final List<LottoTicket> tickets;

  public LottoTickets(List<LottoTicket> tickets){
    this.tickets = tickets;
  }

  public GameResult match(WinningTicket winning) {
    GameResult gameResult = new GameResult();
    for(LottoTicket ticket : tickets){
      gameResult.updateRank(winning.match(ticket));
    }
    return gameResult;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (LottoTicket ticket : tickets) {
      sb.append(ticket).append("\n");
    }
    return sb.toString();
  }

}
