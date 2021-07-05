package lotto.model;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countWinningNumbers(Lotto lotto) {
        return lotto.countWinningNumbers(winningNumbers);
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
