package step2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5,3_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NO_PRIZE(0, 0);

    private static final int MATCH_COUNT_SECOND_OR_THIRD = 5;
    private final int matchCount;
    private final long prizeMoney;

    LottoRank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank evaluateLottoRankByMatchCount(int matchCount, boolean matchBonus) {
        LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(LottoRank.NO_PRIZE); //todo else문을 쓰는게 맞을지 고민 필요.
        if (lottoRank.matchCount == MATCH_COUNT_SECOND_OR_THIRD) {
            return matchBonus ? LottoRank.SECOND_PRIZE : LottoRank.THIRD_PRIZE;
        }
        return lottoRank;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
