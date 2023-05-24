package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(String winningNumbers, int bonusNumber) {
        return new WinningLotto(Lotto.from(winningNumbers), LottoNumber.of(bonusNumber));
    }

    public Match getMatch(Lotto lotto) {
        int count = lotto.getMatchCount(this.lotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);

        return Match.of(count, hasBonusNumber);
    }
}
