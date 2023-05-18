package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    private WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber from(List<Integer> winningNumber) {
        return new WinningNumber(winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
