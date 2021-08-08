package step2.lotto;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final long COUNT_OF_MATCHES_FIRST = 6;
    public static final long COUNT_OF_MATCHES_SECOND = 5;
    public static final long COUNT_OF_MATCHES_THIRD = 4;
    public static final long COUNT_OF_MATCHES_FOURTH = 3;

    private final LottoNumber number;

    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public LottoNumber getNumber() {
        return number;
    }

    public static LottoPrize getLottoPrize(long countOfMatches) {
        if (countOfMatches == 6)
            return LottoPrize.FIRST;

        if (countOfMatches == 5)
            return LottoPrize.SECOND;

        if (countOfMatches == 4)
            return LottoPrize.THIRD;

        if (countOfMatches == 3)
            return LottoPrize.FOURTH;

        return LottoPrize.ETC;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
