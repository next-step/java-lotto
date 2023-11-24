package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public enum LottoRank {
    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    COLLECT_2(2,0),
    COLLECT_1(1,0),
    COLLECT_0(0,0);

    private static final String ERR_INVALID_MATCH_COUNT = "The number of matched lotto numbers cannot exceed 6, as there are a total of 6 lotto numbers.";
    private static final String ERR_BONUS_MATCH_CONDITION = "A bonus number match is only required if 5 numbers are correct.";
    private final int matchCount;
    private final int cashPrize;

    LottoRank(int matchCount, int cash) {
        this.matchCount = matchCount;
        this.cashPrize = cash;
    }

    public static int calculateTotalPrize(List<LottoRank> matchResult) {
        return matchResult.stream()
                .mapToInt(result -> result.cashPrize)
                .sum();
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return checkBonusMatch(matchCount, matchBonus);
        }
        return getByMatchCount(matchCount);
    }

    private static LottoRank checkBonusMatch(int matchCount, boolean matchBonus) {
        if (matchCount != 5) {
            throw new IllegalArgumentException(ERR_BONUS_MATCH_CONDITION);
        }

        if (matchBonus) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    private static LottoRank getByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(cashPrize -> cashPrize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_MATCH_COUNT));
    }

    public int cashPrize() {
        return this.cashPrize;
    }
}
