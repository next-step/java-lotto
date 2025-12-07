package lotto.domain;

public class LottoWinningNumbers {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(Lotto winningLotto, int bonusNumber) {
        this(winningLotto, new LottoNumber(bonusNumber));
    }

    public LottoWinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber.value();
    }

    public LottoRank determineRank(Lotto lotto) {
        return LottoRank.getLottoRank(countMatchedNumbers(lotto), containsBonusNumber(lotto));
    }

    private boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }

    private int countMatchedNumbers(Lotto lotto) {
        return lotto.countMatchedNumbers(this.winningLotto);
    }
}
