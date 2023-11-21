package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0),
    ;

    private final int matchCount;
    private final int money;

    LottoPrize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        if (isThird(matchCount, bonusMatch)) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(v -> (matchCount == v.matchCount))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isThird(int matchCount, boolean bonusMatch) {
        return matchCount == 5 && !bonusMatch;
    }
}
