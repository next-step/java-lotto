package lotto.model;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean containsNumber(int number) {
        return this.winningNumbers.contains(number);
    }

}
