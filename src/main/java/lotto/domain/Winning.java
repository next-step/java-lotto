package lotto.domain;

import lotto.dto.WinningInfoDTO;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000);

    private int correctCount;
    private int bonusCorrectCount;
    private int winningAmount;

    Winning(int correctCount, int bonusCorrectCount, int winningAmount) {
        this.correctCount = correctCount;
        this.bonusCorrectCount = bonusCorrectCount;
        this.winningAmount = winningAmount;
    }

    public static int winningAmount(int correctCount, int bonusCorrectCount) {
        if (correctCount == 5) {
            return Arrays.stream(Winning.values())
                    .filter(value -> value.correctCount == correctCount && value.bonusCorrectCount == bonusCorrectCount)
                    .map(value -> value.winningAmount)
                    .findFirst()
                    .orElse(0);
        }
        return Arrays.stream(Winning.values())
                .filter(value -> value.correctCount == correctCount)
                .map(value -> value.winningAmount)
                .findFirst()
                .orElse(0);
    }

    public static boolean hasMatchingCounts(WinningInfoDTO winningInfoDTO, Winning winning) {
        if (winningInfoDTO.getCorrectCount() == winning.correctCount()
                && winningInfoDTO.getBonusCorrectCount() == winning.bonusCorrectCount()) {
            return true;
        }
        return false;
    }

    public int correctCount() {
        return this.correctCount;
    }

    public int bonusCorrectCount() {
        return this.bonusCorrectCount;
    }

    public int winningAmount() {
        return this.winningAmount;
    }
}
