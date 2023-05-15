package lotto;

import java.util.Objects;

public class BonusBall {

  private final Integer bonusNumber;

  public BonusBall(WinningNumbers winningNumbers, int bonusNumber) {
    if (winningNumbers.has(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복되지 않아야합니다.");
    }
    this.bonusNumber = bonusNumber;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }

  public boolean equals(Integer number) {
    return Objects.equals(bonusNumber, number);
  }
}
