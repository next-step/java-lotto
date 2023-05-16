package domain;

import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(int count) {
        return winningNumbers.contains(count);
    }
}
