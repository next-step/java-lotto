package lotto.domain;

import lotto.exception.DuplicatedBonusLottoNumberException;

public class WinningInfo {

  private final LottoNumbers winningLottoNumbers;
  private final LottoNumber bonusLottoNumber;

  public WinningInfo(int[] winningNumbers, int bonusNumber) {
    this(new LottoNumbers(winningNumbers), LottoNumber.valueOf(bonusNumber));
  }

  public WinningInfo(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
    this.winningLottoNumbers = winningLottoNumbers;
    this.bonusLottoNumber = bonusLottoNumber;
    validateBonusLottoNumber();
  }

  public LottoNumbers winningLottoNumbers() {
    return winningLottoNumbers;
  }

  public LottoNumber bonusLottoNumber() {
    return bonusLottoNumber;
  }

  private void validateBonusLottoNumber() {
    if (winningLottoNumbers.contains(bonusLottoNumber)) {
      throw new DuplicatedBonusLottoNumberException();
    }
  }
}
