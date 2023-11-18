package step2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5,1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NO_PRIZE(0, 0);

    private static final Map<Integer, LottoRank> lottoRanks =
            Stream.of(values()).collect(Collectors.toMap(rank -> rank.matchCount, rank -> rank));
    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank evaluateLottoRankByMatchCount(int matchCount) {
        if (matchCount < 3) {
            return LottoRank.NO_PRIZE;
        }
        return lottoRanks.get(matchCount);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
