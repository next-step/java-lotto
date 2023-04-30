package step2.domain;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> winningNumbers() {
        return winningNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
