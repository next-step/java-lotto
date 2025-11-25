package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.game.Random;
import lotto.domain.result.GameResult;

public class LottoTickets {
  private final List<LottoTicket> tickets;

  public LottoTickets(int cnt) {
    this(generate(cnt));
  }

  public LottoTickets(List<LottoTicket> tickets){
    this.tickets = tickets;
  }

  private static List<LottoTicket> generate(int cnt){
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      tickets.add(new LottoTicket(Random.generate()));
    }
    return tickets;
  }

  public GameResult match(WinningTicket winning) {
    GameResult gameResult = new GameResult();
    for(LottoTicket ticket : tickets){
      gameResult.updateRank(winning.match(ticket));
    }
    return gameResult;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(tickets.size()+"개를 구매했습니다.\n");
    for (int i = 0; i < tickets.size(); i++) {
      sb.append(tickets.get(i) + "\n");
    }
    return sb.toString();
  }

}
