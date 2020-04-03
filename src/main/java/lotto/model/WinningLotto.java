package lotto.model;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusBall;

    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }
}
