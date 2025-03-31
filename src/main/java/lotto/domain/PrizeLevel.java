package lotto.domain;

import java.util.function.Predicate;

import static java.util.Arrays.stream;

public enum PrizeLevel {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5000원)"),
    NO_PRIZE(0, false, 0, "꽝");

    private final int matchingCount;
    private final boolean bonus;
    private final int price;
    private final String message;

    PrizeLevel(int matchingCount, boolean bonus, int price, String message) {
        this.matchingCount = matchingCount;
        this.bonus = bonus;
        this.price = price;
        this.message = message;
    }

    public static final int BONUS_MATCHING_COUNT = 5;

    public static PrizeLevel getPrizeLevel(int matchingCount, boolean bonus) {
        return stream(values())
            .filter(getPrizeLevelPredicate(matchingCount, bonus))
            .findFirst()
            .orElse(NO_PRIZE);
    }

    private static Predicate<PrizeLevel> getPrizeLevelPredicate(int matchingCount, boolean bonus) {
        return level -> level.matchingCount == matchingCount && level.bonus == bonus;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
