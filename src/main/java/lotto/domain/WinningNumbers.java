package lotto.domain;

import java.util.List;

public class WinningNumbers {
  private final LottoTicket winningNumber;

  private WinningNumbers(LottoTicket winningNumber) {
    this.winningNumber = winningNumber;
  }

  public static WinningNumbers of(List<Integer> numbers) {
    return new WinningNumbers(LottoTicket.generate(numbers));
  }

  public boolean isSame(List<Integer> numbers) {
    return this.winningNumber.isSame(numbers);
  }

  public int matchNumberCount(LottoTicket myLottoTicket) {
    return winningNumber.getMatchCount(myLottoTicket);
  }
}
