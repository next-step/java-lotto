package lotto3.domain;

import java.util.List;

public class WinningNumbers {

  private static final int WINNING_NUMBERS_START = 1;
  private static final int WINNING_NUMBERS_END = 45;

  private final List<Integer> winningNumbers;

  public WinningNumbers(List<Integer> winningNumbers) {
    this.winningNumbers = winningNumbers;
  }

  public boolean isBetweenOneAndFortyFive() {
    return winningNumbers.stream()
        .allMatch(number -> number >= WINNING_NUMBERS_START && number <= WINNING_NUMBERS_END);
  }


  public boolean contains(Integer number) {
    return winningNumbers.contains(number);
  }

  public void addBonusNumber(int bonusNumber) {
    winningNumbers.add(bonusNumber);
  }
}
