package lotto;

import java.security.InvalidParameterException;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

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
            throw new InvalidParameterException("bonusNumber와 winningLotto 숫자는 중복될 수 없습니다.");
    }
}
