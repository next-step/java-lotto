package domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false,5_000, "3개 일치 (5000원)"),
    FOURTH(4, false,50_000, "4개 일치 (50000원)"),
    THIRD(5, false,1_500_000, "5개 일치 (1500000원)"),
    SECOND(5, true,30_000_000, "5개 일치 (30000000원)"),
    FIRST(6, false,2_000_000_000, "6개 일치 (2000000000원)");

    private final int matchCount;
    private final boolean isBonusNumberMatched;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean isBonusNumberMatched, int prize, String message) {
        this.matchCount = matchCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prize = prize;
        this.message = message;
    }

    public static Rank of(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && (matchCount != 5 || rank.isBonusNumberMatched == isBonusNumberMatched))
                .findFirst()
                .orElse(null);
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
