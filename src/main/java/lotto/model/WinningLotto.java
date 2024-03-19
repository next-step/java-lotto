package lotto.model;

import lotto.exception.InvalidLottoException;

import static lotto.validation.WinningInfoValidator.assertDuplicatedBonus;

public class WinningLotto {
    private final Lotto winningNumberLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumberLotto, LottoNumber bonusNumber) {
        assertNull(winningNumberLotto, bonusNumber);
        assertDuplicatedBonus(winningNumberLotto, bonusNumber);

        this.winningNumberLotto = winningNumberLotto;
        this.bonusNumber = bonusNumber;
    }

    private void assertNull(Lotto winningNumberLotto, LottoNumber bonusNumber) {
        if (winningNumberLotto == null) {
            throw new InvalidLottoException("당첨 번호가 존재하지 않습니다");
        }

        if (bonusNumber == null) {
            throw new InvalidLottoException("보너스 번호가 존재하지 않습니다");
        }
    }

    public int compareWith(Lotto userLotto) {
        return this.winningNumberLotto.matchNumberCount(userLotto);
    }

    public boolean containsBonusNumberIn(Lotto userLotto) {
        return userLotto.contains(this.bonusNumber);
    }
}
