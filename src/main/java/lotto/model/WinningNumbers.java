package lotto.model;

public class WinningNumbers {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this(winningLotto, new LottoNumber(bonusNumber));
    }

    public int countCorrect(Lotto lotto) {
        return winningLotto.countCorrect(lotto);
    }

    public boolean correctBonus(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
