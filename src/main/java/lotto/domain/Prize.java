package lotto.domain;

import java.util.Arrays;

import java.util.NoSuchElementException;


public enum Prize {

    ZERO(0, 0d),
    ONE(1, 0d),
    TWO(2, 0d),
    THREE(3, 5000d),
    FOUR(4, 50000d),
    FIVE(5, 1_500_000d),
    BONUS(5, 30_000_000d),
    SIX(6, 2_000_000_000d);

    private int matchCount;
    private double earnings;

    Prize(int matchCount, double earnings) {
        this.matchCount = matchCount;
        this.earnings = earnings;
    }

    public static Prize findPrizeByMatchCount(int matchCount, boolean containsBonus) {
        if (matchCount != FIVE.matchCount) {
            return findPrizeByMatchCount(matchCount);
        }
        return containsBonus ? BONUS : FIVE;
    }

    private static Prize findPrizeByMatchCount(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getEarnings() {
        return earnings;
    }

}
