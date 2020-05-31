package lotto.domain;

import lotto.collections.WinningNumbers;

public class LottoNumber {

  protected final Integer number;

  public LottoNumber(Integer number) {
    this.number = validateNumberInRange(number);
  }

  public boolean getMatchCounts(final WinningNumbers winningNumbers) {
    return winningNumbers.getWinningNumbers().stream()
        .anyMatch(winningNumber -> winningNumber.getNumber().equals(number));
  }

  private int validateNumberInRange(Integer number) {
    if (number < 1 || number > 45) {
      throw new RuntimeException("winning number should be in between 1 and 45.");
    }
    return number;
  }

  public Integer getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
