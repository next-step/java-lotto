package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private final BonusBall bonusBall;

    private WinningNumber(List<Integer> winningNumber, BonusBall bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    public static WinningNumber from(List<Integer> winningNumber, BonusBall bonusBall) {
        return new WinningNumber(winningNumber, bonusBall);
    }

    public int countMatchingNumber(List<Integer> numbers) {
        return (int) winningNumber.stream()
                .filter(w -> numbers.contains(w))
                .count();
    }

    public boolean isBonusBallMatched(List<Integer> numbers) {
        return numbers.contains(bonusBall.getBonusBall());
    }
}
