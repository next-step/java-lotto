package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String numberTexts, int bonusNumber) {
        return new WinningLotto(Lotto.of(numberTexts), LottoNumber.of(bonusNumber));
    }

    public Ranking match(Lotto lotto) {
        return lotto.findRankingByLotto(this.lotto, this.bonusNumber);
    }
}
