package lotto.domain;

import lotto.exception.InputError;

public class WinningLotto {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private final Lotto winningLotto;
    private final int bonusBallNumber;

    public WinningLotto(final Lotto winningLotto, final int bonusBallNumber) {
        validBonusBallNumber(winningLotto, bonusBallNumber);
        this.winningLotto = winningLotto;
        this.bonusBallNumber = bonusBallNumber;
    }

    private void validBonusBallNumber(Lotto winningLotto, int bonusBallNumber) {
        if (winningLotto.contains(bonusBallNumber)) {
            throw new InputError("보너스볼 번호는 당첨 번호에 포함되어선 안됩니다.");
        }
        if (bonusBallNumber < MIN_NUMBER || bonusBallNumber > MAX_NUMBER) {
            throw new InputError("올바른 로또 번호가 아닙니다. 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusBallNumber() {
        return bonusBallNumber;
    }
}
