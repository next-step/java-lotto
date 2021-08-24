package lotto.domain;

import lotto.exception.InputError;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusBallNumber;

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusBallNumber) {
        validateBonusBallNumber(winningLotto, bonusBallNumber);
        this.winningLotto = winningLotto;
        this.bonusBallNumber = bonusBallNumber;
    }

    private void validateBonusBallNumber(Lotto winningLotto, LottoNumber bonusBallNumber) {
        if (winningLotto.contains(bonusBallNumber)) {
            throw new InputError("보너스볼 번호는 당첨 번호에 포함되어선 안됩니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBallNumber() {
        return bonusBallNumber;
    }
}
