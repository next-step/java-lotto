package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusBallNumber;

    public WinningLotto(final Lotto winningLotto, final int bonusBallNumber) {
        this.winningLotto = winningLotto;
        this.bonusBallNumber = bonusBallNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusBallNumber() {
        return bonusBallNumber;
    }
}
