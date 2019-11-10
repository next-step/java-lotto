package step2.domain;

public enum LottoMatch {
    NONE(0),

    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private final long winningPrice;

    LottoMatch(final long winningPrice) {
        this.winningPrice = winningPrice;
    }

    public static LottoMatch of(final long count) {
        if (count == 3) {
            return THREE;
        }
        if (count == 4) {
            return FOUR;
        }
        if (count == 5) {
            return FIVE;
        }
        if (count == 6) {
            return SIX;
        }
        return NONE;
    }
}
