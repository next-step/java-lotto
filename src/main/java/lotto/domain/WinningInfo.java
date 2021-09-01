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
    return this.winningLottoNumbers;
  }

  public LottoNumber bonusLottoNumber() {
    return this.bonusLottoNumber;
  }

  private void validateBonusLottoNumber() {
    if (this.winningLottoNumbers.contains(this.bonusLottoNumber)) {
      throw new DuplicatedBonusLottoNumberException();
    }
  }
}
