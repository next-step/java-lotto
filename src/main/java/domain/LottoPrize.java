package domain;

public enum LottoPrize {
    FIRST_PRIZE(6L, 2000000000L),
    SECOND_PRIZE(5L, 1500000L),
    THIRD_PRIZE(4L, 50000L),
    FOURTH_PRIZE(3L, 5000L);

    private final Long matchingNumber;
    private final Long prizeValue;

    LottoPrize(final Long matchingNumber, final Long prizeValue) {
        this.matchingNumber = matchingNumber;
        this.prizeValue = prizeValue;
    }

    public boolean isWon(Long number) {
        return matchingNumber.equals(number);
    }

    public Long getPrizeValue() {
        return prizeValue;
    }
}
