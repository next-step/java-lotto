package lotto;

import java.util.Arrays;

public enum LottoResult {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingCount;
    private final int prize;

    LottoResult(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoResult of(int matchingCount, boolean bonus) {
        if (matchingCount == 5 && bonus) {
            return SECOND;
        }
        if (matchingCount == 5) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(result -> result.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonus() {
        return this == SECOND;
    }

    public int getPrize() {
        return prize;
    }
}
