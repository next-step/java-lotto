package lotto.domain;

public enum LottoPrizeType {
    ONE_PRIZE(2_000_000_000, 6),
    TWO_PRIZE(1_500_000, 5),
    THREE_PRIZE(50_000, 4),
    FOUR_PRIZE(5_000, 3),
    NONE(0, 0),
    ;
    private final int prize;
    private final int match;

    LottoPrizeType(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public static LottoPrizeType of(Integer prizeNumber) {
        validatePrizeNumber(prizeNumber);

        LottoPrizeType[] values = LottoPrizeType.values();

        for (LottoPrizeType value : values) {
            LottoPrizeType value1 = getLottoPrizeType(prizeNumber, value);
            return value1;
        }
        return NONE;
    }

    private static LottoPrizeType getLottoPrizeType(Integer prizeNumber, LottoPrizeType value) {
        if (value.matchCount(prizeNumber)) {
            return value;
        }
        return null;
    }

    private static void validatePrizeNumber(Integer integer) {
        if (integer < 0 || integer > 6) {
            throw new IllegalArgumentException("Lotto 당첨 범위를 넘어갑니다.");
        }
    }

    private boolean matchCount(Integer value) {
        return this.match == value;
    }

    public Integer getPrize() {
        return prize;
    }

    public int getPrizeByCount(int count) {
        return prize * count;
    }

    public Integer getMatch() {
        return match;
    }
}
