package lotto;

public class BonusBall {

  private final Integer bonusNumber;

  public BonusBall(WinningNumbers winningNumbers, int bonusNumber) {
    if (winningNumbers.has(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복되지 않아야한다.");
    }
    this.bonusNumber = bonusNumber;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }
}
