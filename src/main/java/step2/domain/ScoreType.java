package step2.domain;

import java.util.Arrays;

public enum ScoreType {
    NONE(0, "", 0, false),
    THREE(5000, " (5000원)", 3, false),
    FOUR(50000, " (50000원)", 4, false),
    FIVE(1500000, " (1500000원)", 5, false),
    FIVE_BONUS(30000000, ", 보너스 볼 일치(30000000원)", 5, true),
    SIX(2000000000, " (2000000000원)", 6, false);

    private int prize;
    private String WinnerMsg;
    private int targetNumber;
    private boolean hasBonus;

    ScoreType(int prize, String WinnerMsg, int targetNumber, boolean hasBonus) {
        this.prize = prize;
        this.WinnerMsg = WinnerMsg;
        this.targetNumber = targetNumber;
        this.hasBonus = hasBonus;
    }

    public static ScoreType getScore(int inputNumber) {
        return Arrays.stream(values())
                .filter(i -> i.getTargetNumber() == inputNumber)
                .findFirst()
                .orElse(NONE);
    }

    public static ScoreType getScore(int inputNumber, boolean hasBonusNum) {
        return Arrays.stream(values())
                     .filter(i -> i.getTargetNumber() == inputNumber)
                     .filter(i -> i.isHasBonus() == hasBonusNum)
                     .findFirst()
                     .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public String getWinnerMsg() {
        return WinnerMsg;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }
}
