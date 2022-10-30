package lotto.domain;

public enum Prize {
    SIX(2000000000),
    FIVE_BONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000),
    NONE(0);

    private final int value;

    Prize(int value) {
        this.value = value;
    }

    public static Prize toPrize(int matchCount) {
        if (matchCount == 6) return SIX;
        if (matchCount == 5) return FIVE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 3) return THREE;
        return NONE;
    }

    public int getValue() {
        return value;
    }
}
