package lotto.model;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningLottoNumbers = winningNumbers;
    }

    public int correctCount(LottoNumbers lottoNumbers) {
        lottoNumbers.removeAll(winningLottoNumbers);
        return LOTTO_NUMBER_COUNT - lottoNumbers.lottoNumbers().size();
    }
}
