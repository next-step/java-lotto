package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }

        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public WinningLotto(String lotto, int bonusNumber) {
        this(new Lotto(lotto), bonusNumber);
    }

    public int match(Lotto winningLotto) {
        return this.lotto.match(winningLotto);
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
