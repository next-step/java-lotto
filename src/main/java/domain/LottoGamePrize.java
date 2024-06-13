package domain;

public enum LottoGamePrize {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    NONE(0);

    private final long value;

    LottoGamePrize(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
