package lotto.input;

import java.util.List;

public final class WinningNumber {

  private final int[] winningNumbers;
  private final int bonusNumber;

  public WinningNumber(int[] winningNumbers, int bonusNumber) {
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  public int[] getWinningNumbers() {
    return winningNumbers;
  }

  public boolean isMatchBonusNumberWith(List<Integer> numbers) {
    return numbers.contains(this.bonusNumber);
  }
}
