package lotto.model;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;

        checkWinningNumbers(this.winningNumber);
        checkBonusNumber(this.bonusNumber);
    }

    private void checkWinningNumbers(Lotto winningNumber) {
        for (int number : winningNumber.getNumbers()) {
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

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
