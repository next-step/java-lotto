package lotto;

public class WinningNumbers {

  private static final String ERROR_DUPLICATE_BONUS = "보너스 번호와 당첨 번호는 중복 불가합니다";

  private final Lotto winningNumbers;
  private final LottoNumber bonusNumber;

  public WinningNumbers(Lotto winningNumber, LottoNumber bonusNumber) {
    validateDuplicate(winningNumber, bonusNumber);
    this.winningNumbers = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public Lotto winningNumbers() {
    return winningNumbers;
  }

  public LottoNumber bonusNumber() {
    return bonusNumber;
  }

  private void validateDuplicate(Lotto winningNumber, LottoNumber bonusNumber) {
    if (winningNumber.contains(bonusNumber)) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
    }
  }

}
