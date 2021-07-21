package lotto.model;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        checkBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호는 모두 다른 숫자여야 합니다.");
        }
    }

    public int countWinningNumbers(Lotto lotto) {
        return lotto.countWinningNumbers(winningNumbers);
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
