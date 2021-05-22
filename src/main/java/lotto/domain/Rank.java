package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원)- %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)- %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)- %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)- %d개"),
    MISS(0, 0, "");

    private final int matchCount;
    private final int prizeMoney;
    private final String message;

    Rank(final int matchCount, final int prizeMoney, final String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Rank valueOf(final int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
