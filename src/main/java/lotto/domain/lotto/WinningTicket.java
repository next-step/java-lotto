package lotto.domain.lotto;

import lotto.domain.game.Rank;

public class WinningTicket {
  private final LottoTicket ticket;
  private final LottoNumber bonus;

  public WinningTicket(String numbers, int bonus){
    this(new LottoTicket(numbers), LottoNumber.of(bonus));
  }

  public WinningTicket(LottoTicket ticket, LottoNumber bonus) {
    validate(ticket, bonus);
    this.ticket = ticket;
    this.bonus = bonus;
  }
  private static void validate(LottoTicket ticket, LottoNumber bonus){
    if(ticket.contains(bonus))throw new IllegalArgumentException("당첨 번호와 중복됩니다.");

  }
  public Rank match(LottoTicket ticket) {
    return Rank.valueOf(this.ticket.matchCount(ticket), ticket.contains(this.bonus));
  }

}
