package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int matchCount;
    private long amount;

    Rank(int matchCount, long amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(s -> s.matchCount == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("당첨 되지 않았습니다."));
    }

    public long getAmount() {
        return amount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
