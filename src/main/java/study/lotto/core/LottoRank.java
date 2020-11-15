package study.lotto.core;

public enum LottoRank {

    NONE(null,0),
    FOURTH(3,5000),
    THIRD(4,50000),
    SECOND(5,1500000),
    FIRST(6,2000000000);

    private final Integer matchingNumberCount;
    private final Integer prizeAmount;

    LottoRank(Integer matchingNumberCount, Integer prizeAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public Integer getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank of(Lotto lotto) {

        int matchingNumberCount = lotto.getMatchingNumberCount();

        if (matchingNumberCount == 6) {
            return LottoRank.FIRST;
        }

        if (matchingNumberCount == 5) {
            return LottoRank.SECOND;
        }

        if (matchingNumberCount == 4) {
            return LottoRank.THIRD;
        }

        if (matchingNumberCount == 3) {
            return LottoRank.FOURTH;
        }

        return LottoRank.NONE;
    }

}
