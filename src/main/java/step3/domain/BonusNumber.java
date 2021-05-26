package step3.domain;

import step3.exception.DuplicatedNumberException;

public class BonusNumber extends LottoNumber {


    public BonusNumber(Lotto lotto, int bonusNumber) {
        checkDuplicated(lotto, bonusNumber);

        this.number = bonusNumber;
    }

    private void checkDuplicated(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.findLottoNum(new LottoNumber(bonusNumber))) throw new DuplicatedNumberException();
    }

    public boolean isMatchedWithLotto(Lotto anotherLotto) {
        return anotherLotto.findLottoNum(new LottoNumber(number));
    }
}
