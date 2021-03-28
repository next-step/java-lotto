package step2.domain;

import java.util.Arrays;

public enum Prize {
    FAIL(0, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    ALL_MATCH(6, 2000000000);

    private int matchCount;
    private int amount;

    Prize(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Prize findPrize(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(o -> o.matchCount == matchCount)
                .findFirst()
                .orElse(Prize.FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}
