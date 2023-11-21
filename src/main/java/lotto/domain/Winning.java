package lotto.domain;

import lotto.dto.WinningInfoDTO;

import java.util.Arrays;

public enum Winning {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private int correctCount;
    private boolean bonusCorrect;
    private int winningAmount;

    Winning(int correctCount, boolean bonusCorrect, int winningAmount) {
        this.correctCount = correctCount;
        this.bonusCorrect = bonusCorrect;
        this.winningAmount = winningAmount;
    }

    public static int winningAmount(int correctCount, boolean bonusCorrectCount) {
        if (correctCount == 5) {
            return Arrays.stream(Winning.values())
                    .filter(value -> value.correctCount == correctCount && value.bonusCorrect == bonusCorrectCount)
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

    public static boolean isMatched(WinningInfoDTO winningInfoDTO, Winning winning) {
        if (winning.correctCount == 5) {
            return winningInfoDTO.getCorrectCount() == winning.correctCount()
                    && winningInfoDTO.getBonusCorrect() == winning.bonusCorrectCount();
        }
        return winningInfoDTO.getCorrectCount() == winning.correctCount();
    }

    public int correctCount() {
        return this.correctCount;
    }

    public boolean bonusCorrectCount() {
        return this.bonusCorrect;
    }

    public int winningAmount() {
        return this.winningAmount;
    }
}
