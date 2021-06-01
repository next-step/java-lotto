package lotto.model;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int correctCount(LottoNumbers lottoNumbers) {
        lottoNumbers.removeAll(winningLottoNumbers);
        return LOTTO_NUMBER_COUNT - lottoNumbers.lottoNumbers().size();
    }

    public boolean matchedBonusBall(LottoNumbers purchaseLottoNumber) {
        return purchaseLottoNumber.lottoNumbers().contains(bonusNumber);
    }
}
