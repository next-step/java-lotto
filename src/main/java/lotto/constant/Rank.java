package lotto.constant;

public enum Rank {
    FIFTH(5, 2, 0, "꽝"),
    FOURTH(4, 3, 5000, "3개 일치 (5,000원) - "),
    THIRD(3, 4, 50000, "4개 일치 (50,000원) - "),
    SECOND(2, 5, 1500000, "5개 일치 (1,500,000원) - "),
    FIRST(1, 6, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int number;
    private final int matchingNumberCount;
    private final int prizeMoney;
    private final String description;

    Rank(int number, int matchingNumberCount, int prizeMoney, String description) {
        this.number = number;
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

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getNumber() {
        return number;
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
