package lotto.domain;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOuRTH(4, 50000),
    FIFTH(3, 5000);

    private int correctCount;
    private int winningAmount;

    Winning(int correctCount, int winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public static int winningAmount(int correctCount) {
        return Arrays.stream(Winning.values())
                .filter(value -> value.correctCount == correctCount)
                .map(value -> value.winningAmount)
                .findFirst()
                .orElse(0);
    }
}
