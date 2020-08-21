package step2.domain;

import java.util.Arrays;

public enum Score {
    NONE(0, 0),
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(200000000, 6);

    private int prize;
    private int targetNumber;

    Score(int prize, int targetNumber) {
        this.prize = prize;
        this.targetNumber = targetNumber;
    }

    public static Score getScore(int inputNumber) {
        return Arrays.asList(values())
                .stream()
                .filter(i -> i.getTargetNumber() == inputNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getTargetNumber() {
        return targetNumber;
    }
}
