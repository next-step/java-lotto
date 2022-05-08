package lotto.enums;

import java.util.Arrays;

public enum Grade {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int expectNumber;
    private final int awardPrice;

    Grade(int expectNumber, int awardPrice) {
        this.expectNumber = expectNumber;
        this.awardPrice = awardPrice;
    }

    public int getExpectNumber() {
        return expectNumber;
    }

    public long getAwardPrice() {
        return awardPrice;
    }

    public static Grade valueOf(int countOfMatch, boolean matchBonus) {
        Grade second = Grade.SECOND;
        if (matchBonus && second.expectNumber == countOfMatch) {
            return second;
        }

        return Arrays.stream(values())
                .filter(grade -> !grade.isSecond())
                .filter(grade -> grade.expectNumber == countOfMatch)
                .findFirst()
                .orElse(Grade.NONE);
    }

    public boolean isSecond() {
        return this == Grade.SECOND;
    }
}
