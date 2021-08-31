package lotto;

public class WinningLotto {
    private final Lotto prevWinningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto prevWinningLotto, int bonusNumber) {
        this.prevWinningLotto = prevWinningLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);

        if (this.prevWinningLotto.existNumber(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException("The bonus number must not be included in the winning number.");
        }
    }

    public Rank matchedRank(Lotto lotto) {
        return Rank.valueOf(this.prevWinningLotto.match(lotto), lotto.existNumber(this.bonusNumber));
    }
}
