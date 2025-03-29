package lotto.domain;

import static java.util.Arrays.stream;

public enum PrizeLevel {
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, 1_500_000, "5개 일치 (1500000원)"),
    THIRD(4, 50_000, "4개 일치 (50000원)"),
    FOURTH(3, 5_000, "3개 일치 (5000원)"),
    NO_PRIZE(0, 0, "꽝");

    private final int matchingCount;
    private final int price;
    private final String message;

    PrizeLevel(int matchingCount, int price, String message) {
        this.matchingCount = matchingCount;
        this.price = price;
        this.message = message;
    }

    public static PrizeLevel getPrizeLevel(int matchingCount) {
        return stream(values())
            .filter(level -> level.matchingCount == matchingCount)
            .findFirst()
            .orElse(NO_PRIZE);
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
