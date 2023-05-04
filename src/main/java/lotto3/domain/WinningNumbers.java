package lotto3.domain;

import java.util.List;

public class WinningNumbers {

  private static final int WINNING_NUMBERS_START = 1;
  private static final int WINNING_NUMBERS_END = 45;
  private static final int LOTTO_NUMBERS_SIZE = 6;

  private final List<Integer> winningNumbers;

  public WinningNumbers(List<Integer> winningNumbers) {
    this.winningNumbers = winningNumbers;
    validateHasSixNumbers();
    validateIsBetweenOneAndFortyFive();
  }

  private void validateIsBetweenOneAndFortyFive() {
    if (!isBetweenOneAndFortyFive()) {
      throw new IllegalArgumentException("지난 주 당첨 번호는 1~45 사이의 숫자여야 합니다.");
    }
  }

  private void validateHasSixNumbers() {
    if (!hasSixNumbers()) {
      throw new IllegalArgumentException("지난 주 당첨 번호는 6개를 입력해 주세요.");
    }
  }

  private boolean hasSixNumbers() {
    return winningNumbers.size() == LOTTO_NUMBERS_SIZE;
  }

  private boolean isBetweenOneAndFortyFive() {
    return winningNumbers.stream()
        .allMatch(number -> number >= WINNING_NUMBERS_START && number <= WINNING_NUMBERS_END);
  }


  public boolean contains(Integer number) {
    return winningNumbers.contains(number);
  }

  public void validateHasDuplicateNumber(BonusNumber bonusNumber) {
    if (contains(bonusNumber.getBonusNumber())) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
