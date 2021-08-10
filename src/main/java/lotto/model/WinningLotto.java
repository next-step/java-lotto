package lotto.model;

public class WinningLotto {
<<<<<<< HEAD
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        checkWinningNumbers(this.winningNumbers);
        checkBonusNumber(this.bonusNumber);
    }

    private void checkWinningNumbers(Lotto winningNumbers) {
        for (int number : winningNumbers.getNumbers()) {
            checkNumber(number);
        }
    }

    private void checkBonusNumber(int bonusNumber) {
        checkNumber(bonusNumber);
    }

    private void checkNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지의 숫자입니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
=======
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

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
>>>>>>> origin/step2
    }
}
