package lotto_auto.model;

import lotto_auto.ErrorMessage;

public class WinningLotto {

    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        if (winningLottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
