package lotto.domain;

public enum LottoRank {

    NOT_MATCHED("", 0, new LottoPrize(0, Currency.KRW)),
    FOURTH("3개 일치", 3, new LottoPrize(5000, Currency.KRW)),
    THIRD("4개 일치", 4, new LottoPrize(50000, Currency.KRW)),
    SECOND("5개 일치", 5, new LottoPrize(1500000, Currency.KRW)),
    FIRST("6개 일치", 6, new LottoPrize(2000000000, Currency.KRW));

    private final String description;
    private final int matchedCount;
    private final LottoPrize prize;

    LottoRank(String description,
              int matchedCount,
              LottoPrize prize) {
        this.description = description;
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static LottoRank searchBy(int matchedCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (isMatchedCount(matchedCount, lottoRank)) {
                return lottoRank;
            }
        }
        return NOT_MATCHED;
    }

    private static boolean isMatchedCount(int matchedCount,
                                          LottoRank lottoRank) {
        return lottoRank.matchedCount == matchedCount;
    }

    public int calculatePrize(Integer value) {
        return prize.calculateAmount(value);
    }
}
