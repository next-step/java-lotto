package lotto;

import java.util.List;

public class LottoTickets {

  private final List<LottoTicket> tickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.tickets = tickets;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (LottoTicket lottoTicket : tickets) {
      builder.append(lottoTicket);
      builder.append("\n");
    }

    return builder.toString();
  }

  public static LottoTickets of(List<LottoTicket> tickets) {
    if (tickets == null) {
      throw new NullPointerException();
    }

    return new LottoTickets(tickets);
  }

  public LottoResult settle(WinningNumber winningNumber) {
    LottoResult lottoResult = new LottoResult();
    for (LottoTicket ticket : this.tickets) {
      lottoResult.recordHit(ticket.getNumHit(winningNumber));
    }

    return lottoResult;
  }
}
