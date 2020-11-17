package study.lotto.core;

import java.util.stream.Stream;

public enum LottoRank {

    NONE(null,0),
    FOURTH(3,5_000),
    THIRD(4,50_000),
    SECOND(5,1_500_000),
    FIRST(6,2_000_000_000);

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
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchingNumberCount() == lotto.getMatchingNumberCount())
                .findFirst()
                .orElse(LottoRank.NONE);
    }

}
