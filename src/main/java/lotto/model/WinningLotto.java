package lotto.model;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusLotto;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        this.lotto = lotto;
        this.bonusLotto = lottoNumber;
    }

    public boolean isMatchBonus(LottoNumber lottoNumber) {
        return this.bonusLotto == lottoNumber;
    }

    public boolean isMatch(LottoNumber buyLottoNumber) {
        return lotto.isMatch(buyLottoNumber);
    }
}
