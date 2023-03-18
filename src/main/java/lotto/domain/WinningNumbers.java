package lotto.domain;


public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final int bonusNumber, final int... winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);;
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public WinningGrade getWinningGrade(final Lotto lotto) {
        return WinningGrade.checkWinningGrade(lotto.matchCount(this.winningNumbers), lotto.isContains(this.bonusNumber));
    }

    public int matchWinningCount(Lotto lotto) {
        return this.winningNumbers.matchCount(lotto);
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.isContains(bonusNumber);
    }
}
