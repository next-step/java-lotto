package lotto.domain;

import java.util.Set;

public class WinningNumbers {
  private final LottoTicket winningNumber;
  private final Integer bonusNumber;

  private WinningNumbers(LottoTicket winningNumber, int bonusNumber) {
    this.winningNumber = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public static WinningNumbers of(Set<Integer> numbers, int bonusNumber) {
    return new WinningNumbers(LottoTicket.generate(numbers), bonusNumber);
  }

  public boolean isSame(Set<Integer> numbers) {
    return this.winningNumber.isSame(numbers);
  }

  public int matchNumberCount(LottoTicket myLottoTicket) {
    return winningNumber.getMatchCount(myLottoTicket);
  }

  public boolean isMatchBonusBall(LottoTicket myLottoTicket) {
    return myLottoTicket.contain(bonusNumber);
  }
}
