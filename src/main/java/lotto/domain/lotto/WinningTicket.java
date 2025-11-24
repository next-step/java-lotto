package lotto.domain.lotto;

import lotto.domain.game.Rank;

public class WinningTicket {
  private final LottoTicket ticket;
  private final LottoNumber bonus;

  public WinningTicket(String numbers, int bonus){
    this(new LottoTicket(numbers), LottoNumber.of(bonus));
  }

  public WinningTicket(LottoTicket ticket, LottoNumber bonus) {
    this.ticket = ticket;
    this.bonus = bonus;
  }

  public Rank match(LottoTicket ticket) {
    return Rank.valueOf(this.ticket.matchCount(ticket), ticket.contains(this.bonus));
  }

}
