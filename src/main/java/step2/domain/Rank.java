package step2.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "0개 일치 (0)"),
    FIFTH(3, 5_000, "3개 일치 (5000)"),
    FOURTH(4, 50_000, "4개 일치 (50000)"),
    THIRD(5, 1_500_000, "5개 일치 (1500000)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000)");

    private static final int THIRD_COUNT = 5;

    private int matchCount;
    private long prizeMoney;

    private String message;

    Rank(int matchCount, long rank, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = rank;
        this.message = message;
    }

    public static Rank toPrizeMoney(int matchCount) {
        if (matchCount == THIRD_COUNT) {
            return Rank.THIRD;
        }

        return Arrays.stream(values())
                .filter(prizeMoney -> prizeMoney.matchCount == matchCount)
                .findAny()
                .orElse(Rank.MISS);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public long prizeMoney() {
        return this.prizeMoney;
    }

    public String message() {
        return this.message;
    }
}
