package lotto.constant;

public enum Rank {
    FIFTH(5, 2, "꽝"),
    FOURTH(4, 3, "3개 일치 (5,000원) - "),
    THIRD(3, 4, "4개 일치 (50,000원) - "),
    SECOND(2, 5, "5개 일치 (1,500,000원) - "),
    FIRST(1, 6, "6개 일치 (2,000,000,000원) - ");

    private final int matchingNumberCount;
    private final int prizeMoney;
    private final String description;

    Rank(int matchingNumberCount, int prizeMoney, String description) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Rank value(int matchingCount) {
        if (matchingCount < 3) return FIFTH;
        for (Rank value : values()) {
            if (value.matchingNumberCount == matchingCount) {
                return value;
            }
        }
        throw new IllegalArgumentException("number is wrong rank.");
    }
}
