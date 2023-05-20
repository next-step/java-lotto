package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;
    BonusBall bonusBall;

    private WinningNumber(List<Integer> winningNumber, BonusBall bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    public static WinningNumber from(List<Integer> winningNumber, BonusBall bonusBall) {
        return new WinningNumber(winningNumber, bonusBall);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }
}
