package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoRank {
    THREE(3, value -> value * 5_000),
    FOUR(4, value -> value * 50_000),
    FIVE(5, value -> value * 1_500_000),
    SIX(6, value -> value * 2_000_000_000),
    NONE(0, value -> 0);

    private int matchCount;
    private Function<Integer, Integer> prizes;

    LottoRank(int matchCount, Function<Integer, Integer> prizes) {
        this.matchCount = matchCount;
        this.prizes = prizes;
    }

    public static LottoRank findMatchCount(Integer matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findAny()
                .orElse(LottoRank.NONE);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int calculatePrize(int value) {
        return prizes.apply(value);
    }

}
