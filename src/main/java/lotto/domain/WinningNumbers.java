package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(LottoNumbers lottoNumbers){
        return winningNumbers.getMatchCount(lottoNumbers);
    }

    public boolean checkBonusNumber(LottoNumbers lottoNumbers){
        return lottoNumbers.isContained(bonusNumber);
    }
}
