package lotto.domain;

import lotto.exception.ExceptionType;
import lotto.exception.LottoException;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, String bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = Integer.parseInt(bonusNumber);

        checkBonusNumber();
    }

    public int getMatchCount(Lotto lotto) {
        return this.lotto.getMatchCount(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }

    private void checkBonusNumber() {
        if(lotto.contains(this.bonusNumber)) {
            throw new LottoException(ExceptionType.DUPLICATED_LOTTO_BONUS_NUMBER);

        };
    }
}
