package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoRank {
    FIRST(6, value -> value * 2_000_000_000),
    SECOND(5, value -> value * 30_000_000),
    THIRD(5, value -> value * 1_500_000),
    FOURTH(4, value -> value * 50_000),
    FIFTH(3, value -> value * 5_000),
    MISS(0, value -> 0);

    private int matchCount;
    private Function<Integer, Integer> prizes;

    LottoRank(int matchCount, Function<Integer, Integer> prizes) {
        this.matchCount = matchCount;
        this.prizes = prizes;
    }

    public static LottoRank findMatchCount(Integer matchCount, boolean isContainsBonus) {
        if (matchCount == LottoRank.SECOND.getMatchCount() && isContainsBonus) {
            return LottoRank.SECOND;
        }

        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount && !lottoRank.equals(SECOND))
                .findAny()
                .orElse(LottoRank.MISS);
    }


    public int getMatchCount() {
        return this.matchCount;
    }

    public int calculatePrize(int value) {
        return prizes.apply(value);
    }

}
