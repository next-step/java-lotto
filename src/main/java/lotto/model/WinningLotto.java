package lotto.model;

public class WinningLotto {

    private Lotto2 lotto;

    private int bonusNumber;

    public WinningLotto(Lotto2 lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto2 getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
