package lotto.domain;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(String winningLottoString, int bonus) {
        this.winningLotto = LottoBox.parseNumberString(winningLottoString);
        this.bonusNumber = new LottoNumber(bonus);
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.getRank(lotto.compare(winningLotto), lotto.contains(bonusNumber));
    }
}
