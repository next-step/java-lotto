package lotto;

public enum Rank {
    FIRST(6, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, "5개 일치 (1,500,000원) - "),
    THIRD(4, "4개 일치 (50,000원) - "),
    FOURTH(3, "3개 일치 (5,000원) - "),
    FIFTH(2, "꽝"),
    ;

    private final int matchingNumberCount;
    private final String description;

    Rank(int matchingNumberCount, String description) {
        this.matchingNumberCount = matchingNumberCount;
        this.description = description;
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
