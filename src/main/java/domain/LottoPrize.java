package domain;

public enum LottoPrize {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NOTHING(0, 0);

    private final int matchingNumber;
    private final int prizeValue;

    LottoPrize(final int matchingNumber, final int prizeValue) {
        this.matchingNumber = matchingNumber;
        this.prizeValue = prizeValue;
    }

    public int getMatchingNumber() { return matchingNumber; }
    public int getPrizeValue() {
        return prizeValue;
    }

    public static LottoPrize of(int matchingNumber){
        for(LottoPrize lottoPrize : LottoPrize.values()) {
            if(lottoPrize.getMatchingNumber() == matchingNumber) {
                return lottoPrize;
            }
        }

        return LottoPrize.NOTHING;
    }
}
