package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0,""),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30,000,000원)"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private int matchCount;
    private int amount;
    private String message;

    Rank(final int matchCount, final int amount, final String message) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.message = message;
    }

    public static Rank valueOf(final int matchCount, final boolean matchBonus) {
        if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(SECOND))
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int matchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }


}
