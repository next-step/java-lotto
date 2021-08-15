package lotto.domain;

public class WinnerLotto {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    public WinnerLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
