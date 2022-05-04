package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

public class LottoWinningCondition {
    private Lotto previousLotto;
    private LottoNumber bonusNumber;

    public LottoWinningCondition(Lotto previousLotto, LottoNumber bonusNumber) {
        checkLottoWinningCondition(previousLotto, bonusNumber);
        this.previousLotto = previousLotto;
        this.bonusNumber = bonusNumber;
    }

    void checkLottoWinningCondition(Lotto previousLotto, LottoNumber bonusNumber) {
        if (previousLotto.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber.getLottoNumber());
        }
    }

    LottoWinnerType winLotto(Lotto lotto) {
        return LottoWinnerType.valueOf(lotto.countDuplicateValue(previousLotto), lotto.contains(bonusNumber));
    }
}
