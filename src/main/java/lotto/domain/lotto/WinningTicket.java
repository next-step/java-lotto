package lotto.domain.lotto;

import java.util.List;

public class WinningTicket extends LottoTicket{
  private final LottoNumber bonus;

  public WinningTicket(String numbers, int bonus){
    super(numbers);
    this.bonus = LottoNumber.of(bonus);
  }

  public WinningTicket(List<LottoNumber> numbers, LottoNumber bonus) {
    super(numbers);
    this.bonus = bonus;
  }

  public boolean containsBonus(LottoTicket purchased){
    return purchased.contains(bonus);
  }
}
