package study.lotto.domain;


public class WinningLotto {
    Lotto winningLotto;
    LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lotto() {
        return winningLotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }


}
