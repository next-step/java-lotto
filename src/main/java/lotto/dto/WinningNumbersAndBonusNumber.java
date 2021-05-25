package lotto.dto;

import java.util.List;
import java.util.Objects;

public class WinningNumbersAndBonusNumber {

  private final List<Integer> winningNumbers;
  private final int bonusNumber;

  public WinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  public List<Integer> getWinningNumbers() {
    return winningNumbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WinningNumbersAndBonusNumber that = (WinningNumbersAndBonusNumber) o;
    return bonusNumber == that.bonusNumber && winningNumbers.equals(that.winningNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(winningNumbers, bonusNumber);
  }
}
