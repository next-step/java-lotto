package lotto.domain;

public class LottoWinningCondition {
    private Lotto previousLotto;
    private LottoNumber bonusNumber;

    public LottoWinningCondition(Lotto previousLotto, LottoNumber bonusNumber) {
        this.previousLotto = previousLotto;
        this.bonusNumber = bonusNumber;
    }

    Lotto getPreviousLotto() {
        return previousLotto;
    }

    LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
