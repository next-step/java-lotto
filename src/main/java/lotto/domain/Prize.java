package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public enum Prize {

    ZERO(0, 0d),
    ONE(1, 0d),
    TWO(2, 0d),
    THREE(3, 5000d),
    FOUR(4, 50000d),
    FIVE(5, 1_500_000d),
    SIX(6, 2_000_000_000d);

    private int matchCount;
    private double earnings;

    Prize(int matchCount, double earnings) {
        this.matchCount = matchCount;
        this.earnings = earnings;
    }

    public static double findEarningsByMatchCount(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findAny()
                .map(prize -> prize.earnings)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> getMatchCounts() {
        return Arrays.stream(Prize.values())
                .map(prize -> prize.matchCount)
                .collect(Collectors.toList());
    }
}
