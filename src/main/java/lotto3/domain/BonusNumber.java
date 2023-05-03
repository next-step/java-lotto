package lotto3.domain;

import java.util.List;

public class BonusNumber {

  private static final int BONUS_NUMBER_START = 1;
  private static final int BONUS_NUMBER_END = 45;
  private final int bonusNumber;

  public BonusNumber(int bonusNumber) {
    this.bonusNumber = bonusNumber;
    validateIsBetweenOneAndFortyFive(bonusNumber);
  }

  private void validateIsBetweenOneAndFortyFive(int bonusNumber) {
    if (!isBetweenOneAndFortyFive(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 1부터 45까지의 숫자만 가능합니다.");
    }
  }

  private boolean isBetweenOneAndFortyFive(int bonusNumber) {
    return bonusNumber >= BONUS_NUMBER_START && bonusNumber <= BONUS_NUMBER_END;
  }

  public void validateDuplicate(WinningNumbers winningNumbers) {
    if (winningNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public boolean contains(List<Integer> numbers) {
    return numbers.contains(bonusNumber);
  }
}
