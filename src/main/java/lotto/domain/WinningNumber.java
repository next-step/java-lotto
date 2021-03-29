package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    public WinningNumber() {
        winningNumbers = new ArrayList<>();
    }

    public WinningNumber(List<Integer> winningNumber) {
        this.winningNumbers = winningNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
