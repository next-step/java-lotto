package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lotto() {
        return lotto;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
