package lotto.domain;

public enum LottoMatch {

    DEFAULT(0, 0),

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int matchCount;
    private final int prize;

    LottoMatch(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }

    public static LottoMatch findEnumByMatchCount(int matchCount) {
        for (LottoMatch value : values()) {
            if (value.matchCount == matchCount) {
                return value;
            }
        }
        return DEFAULT;
    }
}
