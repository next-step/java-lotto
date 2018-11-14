package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public int sum(int number) {
        return this.prize * number;
    }

    private boolean isMatchedCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean isSecond(boolean hasBonusBall) {
        return THIRD == this && hasBonusBall;
    }

    public static LottoPrize findPrize(int matchCount, boolean hasBonusBall) {
        LottoPrize prize = valueOf(matchCount);
        if (prize.isSecond(hasBonusBall)) {
            return SECOND;
        }
        return prize;
    }

    public static List<LottoPrize> valuesWithoutNone() {
        return Arrays.stream(LottoPrize.values())
                .filter(value -> value != LottoPrize.NONE)
                .collect(Collectors.toList());
    }

    private static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.isMatchedCount(matchCount))
                .findFirst()
                .orElse(NONE);
    }
}
