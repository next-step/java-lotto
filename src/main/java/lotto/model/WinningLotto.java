package lotto.model;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        checkWinningNumbers(this.winningNumbers);
        checkBonusNumber(this.bonusNumber);
    }

    private void checkWinningNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
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

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
