package study.lotto.core;

import java.util.Objects;
import java.util.stream.Stream;

public enum LottoRank {

    NONE(null,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000);

    private final Integer matchingNumberCount;
    private final Integer prizeAmount;

    LottoRank(Integer matchingNumberCount, Integer prizeAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public Integer getMatchingNumberCount() {
        return Objects.nonNull(matchingNumberCount) ? matchingNumberCount : 0;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank of(WinningLotto winningLotto) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchingNumberCount() == winningLotto.getMatchingNumberCount())
                .findFirst()
                .orElse(LottoRank.NONE);
    }

}
