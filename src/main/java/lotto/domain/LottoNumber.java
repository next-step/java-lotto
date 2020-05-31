package lotto.domain;

import lotto.collections.WinningNumbers;

public class LottoNumber {

  public static final int MINIMUM_NUMBER_BOUND = 1;
  public static final int MAXIMUM_NUMBER_BOUND = 45;

  protected int number;

  public LottoNumber(int number) {
    this.number = validateNumberInRange(number);
  }

  protected LottoNumber() {
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
