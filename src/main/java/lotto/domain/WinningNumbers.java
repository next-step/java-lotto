package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = new LottoNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        ValidBonusNumberDuplication();
    }

    public int checkMatchCount(LottoNumbers lottoNumbers) {
        return winningNumbers.getMatchCount(lottoNumbers);
    }

    public boolean checkBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void ValidBonusNumberDuplication(){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("보너스 숫자가 당첨 숫자와 동일 합니다.");
        }
    }
}
