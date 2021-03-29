package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FAIL(0, 0,""),
    THREE_MATCH(3, 5000, "3개 일치 (5000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1500000원)"),
    ALL_MATCH(6, 2000000000, "6개 일치 (2000000000원)");

    private int matchCount;
    private int amount;
    private String message;

    Prize(final int matchCount, final int amount, final String message) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.message = message;
    }

    public static Prize findPrize(final int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}
