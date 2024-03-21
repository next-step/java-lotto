package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NEXT_CHANCE(0, 0L),
    ;

    private final int matchCount;
    private final long winnings;

    Rank(int matchCount, long winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static Rank valueOf(int matchCount) {
        assertMatchCountLessThanFirstPrize(matchCount);

        return Arrays.stream(values())
                .filter(type -> type.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.NEXT_CHANCE);
    }

    private static void assertMatchCountLessThanFirstPrize(int matchCount) {
        if (matchCount > FIRST.matchCount) {
            throw new IllegalArgumentException("로또는 그 이상의 당첨이 불가능할텐데요.");
        }
    }

    public long winnings() {
        return this.winnings;
    }
}
