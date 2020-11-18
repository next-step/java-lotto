package study.lotto.core;

import java.util.Objects;
import java.util.stream.Stream;

public enum LottoRank {

    NONE(null,0, "2개 이하 일치"),
    FIFTH(3,5_000, "3개 일치"),
    FOURTH(4,50_000, "4개 일치"),
    THIRD(5,1_500_000, "5개 일치"),
    SECOND(5,30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6,2_000_000_000, "6개 일치");

    private final Integer matchingNumberCount;
    private final Integer prizeAmount;
    private final String description;

    LottoRank(Integer matchingNumberCount, Integer prizeAmount, String description) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public Integer getMatchingNumberCount() {
        return Objects.nonNull(matchingNumberCount) ? matchingNumberCount : 0;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank of(WinningLotto winningLotto, boolean matchBonusLottoNumber) {
        LottoRank findLottoRank = Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchingNumberCount() == winningLotto.getMatchingNumberCount())
                .findFirst()
                .orElse(LottoRank.NONE);

        if (findLottoRank == LottoRank.SECOND || findLottoRank == LottoRank.THIRD) {
            return matchBonusLottoNumber ? LottoRank.SECOND : LottoRank.THIRD;
        }

        return findLottoRank;
    }

}
