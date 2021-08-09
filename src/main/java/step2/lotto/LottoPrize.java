package step2.lotto;

public enum LottoPrize {

    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000),
    ETC(0);

    private final long prizeMoney;

    LottoPrize(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize getLottoPrize(long countOfMatches) {
        if (countOfMatches == Lotto.COUNT_OF_MATCHES_FIRST) {
            return LottoPrize.FIRST;
        }

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_SECOND) {
            return LottoPrize.SECOND;
        }

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_THIRD) {
            return LottoPrize.THIRD;
        }

        if (countOfMatches == Lotto.COUNT_OF_MATCHES_FOURTH) {
            return LottoPrize.FOURTH;
        }

        return LottoPrize.ETC;
    }


    public long getPrizeMoney() {
        return prizeMoney;
    }
}
