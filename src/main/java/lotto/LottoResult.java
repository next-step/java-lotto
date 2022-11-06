package lotto;

import java.util.Arrays;

public enum LottoResult {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    BONUS(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingCount;
    private final int prize;

    LottoResult(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoResult of(int matchingCount, boolean bonus) {
        if (matchingCount == 5 && bonus) {
            return BONUS;
        }
        if (matchingCount == 5) {
            return SECOND;
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
        return this == BONUS;
    }

    public int getPrize() {
        return prize;
    }
}
