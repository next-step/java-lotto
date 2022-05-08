package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int checkNumber(int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
