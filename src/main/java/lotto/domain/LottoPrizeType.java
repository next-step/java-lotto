package lotto.domain;

import java.util.Arrays;

public enum LottoPrizeType {
    ONE_PRIZE(2_000_000_000, 6),
    TWO_PRIZE(3_000_000, 5),
    THREE_PRIZE(1_500_000, 5),
    FOUR_PRIZE(50_000, 4),
    FIVE_PRIZE(5_000, 3),
    NONE(0, 0),
    ;
    private final int prize;
    private final int match;

    LottoPrizeType(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public static LottoPrizeType of(int matchCount, boolean matchBonus) {
        validateMatchCount(matchCount);
        if (TWO_PRIZE.match(matchCount) && matchBonus) {
            return TWO_PRIZE;
        }
        return Arrays.stream(LottoPrizeType.values())
            .filter(lottoPrizeType -> TWO_PRIZE != lottoPrizeType && lottoPrizeType.match(matchCount))
            .findFirst()
            .orElse(LottoPrizeType.NONE);
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException("Lotto 당첨 범위를 넘어갑니다.");
        }
    }

    private boolean match(int value) {
        return this.match == value;
    }

    public int getPrize() {
        return prize;
    }

    public int getPrizeByCount(Long count) {
        return (int) (prize * count);
    }

    public int getMatch() {
        return match;
    }
}
