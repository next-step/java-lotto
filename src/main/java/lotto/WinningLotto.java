package lotto;

import static util.Validator.validateArgument;

public class WinningLotto {

  private static final String ERROR_MESSAGE_FOR_INVALID_BONUS_NUMBER =
      "보너스 번호는 당첨 번호와 중복이어서는 안됩니다.";

  private final Lotto winningLotto;
  private final LottoNumber bonusNumber;

  WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
    validateBonusNumber(winningLotto, bonusNumber);
    this.winningLotto = winningLotto;
    this.bonusNumber = bonusNumber;
  }

  public int matchedCount(Lotto other) {
    return winningLotto.getMatchedCount(other);
  }

  public boolean matchedBonus(Lotto other) {
    return other.hasNumber(bonusNumber);
  }

  private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
    validateArgument(
        bonusNumber,
        (arg) -> !winningLotto.hasNumber(arg),
        ERROR_MESSAGE_FOR_INVALID_BONUS_NUMBER
    );
  }
}
