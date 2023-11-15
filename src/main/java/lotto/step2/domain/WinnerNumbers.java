package lotto.step2.domain;

import java.util.Set;

public class WinnerNumbers {
    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public WinnerNumbers(final Lotto winnerLotto, final LottoNumber bonusLottoNumber) {
        this.winnerLotto = winnerLotto;

        validateBonusWinnerNumber(bonusLottoNumber);

        this.bonusNumber = bonusLottoNumber;
    }

    private void validateBonusWinnerNumber(final LottoNumber bonusLottoNumber) {
        if (this.winnerLotto.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("bonus winner number must not be in winner nums");
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Set<LottoNumber> nums() {
        return this.winnerLotto.nums();
    }
}
