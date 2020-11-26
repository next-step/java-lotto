package lotto;

import java.util.List;
import lotto.views.ReadOnlyLottoTickets;

public class LottoTickets implements ReadOnlyLottoTickets {

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

  public LottoResult settle(WinningNumber winningNumber, LottoNumber bonusNumber) {
    LottoResult lottoResult = new LottoResult();
    this.tickets.stream()
        .map(lottoTicket -> lottoTicket.decideRewardWithBonusBall(winningNumber, bonusNumber))
        .forEach(lottoResult::recordHit);

    return lottoResult;
  }

  public void addAll(LottoTickets that) {
    this.tickets.addAll(that.tickets);
  }

  @Override
  public int getNumTicket() {
    return this.tickets.size();
  }

  @Override
  public String getTicket(int idx) {
    return this.tickets.get(idx).toString();
  }
}
