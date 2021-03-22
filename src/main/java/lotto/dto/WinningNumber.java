package lotto.dto;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusBall;

    public WinningNumber(List<Integer> winningNumber, int bonusBall) {
        if (winningNumber.contains(bonusBall)) {
            throw new IllegalArgumentException();
        }

        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }
}
