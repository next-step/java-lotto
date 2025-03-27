package lotto.domain;

public class BonusNumberValidator {
  private BonusNumberValidator() {
  }

  public static void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
    if (winningLotto.getNumbers().contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
