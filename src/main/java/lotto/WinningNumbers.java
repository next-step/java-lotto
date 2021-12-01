package lotto;

import stringformula.exception.DuplicateBonusNumberException;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        checkBonusNumberDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int winningCount(LottoNumbers lottoNumbers) {
        return this.winningNumbers.matchCount(lottoNumbers);
    }

    public boolean isBonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void checkBonusNumberDuplication(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }
}
