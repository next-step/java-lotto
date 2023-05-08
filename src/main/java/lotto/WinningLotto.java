package lotto;

import java.security.InvalidParameterException;

public class WinningLotto {
    Lotto winningLotto;
    BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        checkInput(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningPrice calculateWinningPrice(Lotto lotto) {
        WinningPrice winningPrice = WinningPrice.of(lotto.countEqualNumbers(winningLotto), lotto.countEqualBonusNumber(bonusNumber));
        return winningPrice;
    }

    private void checkInput(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.countEqualBonusNumber(bonusNumber) > 0)
            throw new InvalidParameterException("bounsNumber와 winingLotto숫자는 중복될 수 없습니다.");
    }
}
