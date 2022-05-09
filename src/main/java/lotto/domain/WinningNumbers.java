package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int checkNumber(int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean checkBonus(List<Integer> selectedNumbers) {
        return selectedNumbers.contains(bonusNumber);
    }
}
