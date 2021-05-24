package study.step2.domain;

import static study.step2.Exception.CustomException.BONUS_NUMBER_INVALID_MESSAGE_EXCEPTION;

import java.util.Set;


public class WinningLotto {

  private final Lotto lotto;
  private LottoNumber bonusNumber;

  public WinningLotto(String inputText) {
    this.lotto = new Lotto(inputText);
  }

  public WinningLotto(String inputText, int bonusNumber) {
    lotto = new Lotto(inputText);
    this.bonusNumber = new LottoNumber(bonusNumber);

    bonusValidation(this.bonusNumber);
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

  public void bonusValidation(LottoNumber bonusNumber) {
    if (lotto.isMatchBonus(bonusNumber))
      throw BONUS_NUMBER_INVALID_MESSAGE_EXCEPTION;
  }

  public Set<LottoNumber> getLottoNumbers() {
    return lotto.getLottoNumbers();
  }
}
