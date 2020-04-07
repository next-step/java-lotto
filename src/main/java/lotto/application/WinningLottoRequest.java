package lotto.application;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.rank.WinningLotto;

public class WinningLottoRequest {
    private LottoNumbers lottoNumbers;
    private int bonusNumber;

    public WinningLottoRequest(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinningLotto to() {
        return WinningLotto.of(this);
    }
}
