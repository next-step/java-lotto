package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    private static int MIN_MATCH = 3;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public static LottoPrize from(int count) {
        if (count < MIN_MATCH) {
            return NONE;
        }
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == count)
                .findFirst().get();
    }

    public static LottoPrize from(int count, boolean matchBonus) {
        if (count < MIN_MATCH) {
            return NONE;
        }
        if (count == 5 && !matchBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == count)
                .findFirst().get();
    }

    public String toString(int count) {
        StringBuilder builder = new StringBuilder();
        builder.append(matchCount + "개 일치");
        if (this.equals(LottoPrize.SECOND)) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (" + prize + ")- ");
        builder.append(count + "개");
        return builder.toString();
    }
}
