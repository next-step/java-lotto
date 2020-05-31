package lotto.domain;

import lotto.collections.WinningNumbers;

public class LottoNumber {

  public static final int MINIMUM_NUMBER_BOUND = 1;
  public static final int MAXIMUM_NUMBER_BOUND = 45;

  protected int number;

  public LottoNumber(int number) {
    this.number = number;
  }

  protected LottoNumber() {
  }

  public boolean getMatchCounts(final WinningNumbers winningNumbers) {
    return winningNumbers.getWinningNumbers().stream()
        .anyMatch(number -> number.getNumber().equals(number));
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
