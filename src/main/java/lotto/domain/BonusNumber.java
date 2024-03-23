package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.exception.InValidBonusNumberException;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private BonusNumber(LottoNumber bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumberWithOutWinningNumbers(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberWithOutWinningNumbers(LottoNumber bonusNumber, WinningNumbers winningNumbers) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new InValidBonusNumberException(bonusNumber.lottoNumber());
        }
    }

    public static BonusNumber newBonusNumberWithOutWinningNumbers(LottoNumber bonusNumber, WinningNumbers winningNumbers) {
        return new BonusNumber(bonusNumber, winningNumbers);
    }

    public boolean isMatched(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
