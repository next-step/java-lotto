package lotto.domain;

import lotto.exception.IllegalBonusNumberException;

public class WinningLotto {

    private final LottoNumbers winNumber;
    private final LottoNumber bonusNumber;

    private WinningLotto(LottoNumbers winNumber, LottoNumber bonusNumber) {
        validate(winNumber, bonusNumber);
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(LottoNumbers winNumber, LottoNumber bonusNumber) {
        return new WinningLotto(winNumber, bonusNumber);
    }

    public LottoResult toResult(LottoNumbers lottoNumbers) {
        return LottoResult.of(winNumber.match(lottoNumbers), lottoNumbers.contains(bonusNumber));
    }

    private void validate(LottoNumbers winNumber, LottoNumber bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalBonusNumberException(bonusNumber.initNumber());
        }
    }
}
