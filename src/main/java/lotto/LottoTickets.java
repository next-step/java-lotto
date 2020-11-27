package lotto;

import java.util.List;
import lotto.dto.LottoTicketsDTO;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = tickets;
  }

  public static LottoTickets of(List<LottoTicket> tickets) {
    if (tickets == null) {
      throw new NullPointerException();
    }

    return new LottoTickets(tickets);
  }

  public LottoResult settle(WinningNumber winningNumber) {
    LottoResult lottoResult = new LottoResult();
    this.tickets.stream()
        .map(lottoTicket -> lottoTicket.rewardsWithBonusBall(winningNumber))
        .forEach(lottoResult::recordHit);

    return lottoResult;
  }

  public LottoTicketsDTO exportData() {
    return new LottoTicketsDTO(this.tickets);
  }
}
