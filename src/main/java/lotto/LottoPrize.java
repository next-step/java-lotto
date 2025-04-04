package lotto;

public enum LottoPrize {
    SIX_MATCH(6, 2000000000),
    FIVE_MATCH(5, 30000000),
    FOUR_MATCH(4, 1500000),
    THREE_MATCH(3, 50000),
    TWO_MATCH(2, 0),
    ONE_MATCH(1, 0),
    ZERO_MATCH(0, 0);

    private final int matchCount;
    private final int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int getPrize(int matchCount) {
        for (LottoPrize prize : values()) {
            if (prize.matchCount == matchCount) {
                return prize.prize;
            }
        }
        throw new IllegalArgumentException("Invalid match count: " + matchCount);
    }
}
