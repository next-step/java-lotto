package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    MATCH_COUNT_SIX(6, 2000000000),
    MATCH_COUNT_FIVE(5, 1500000),
    MATCH_COUNT_FOUR(4, 50000),
    MATCH_COUNT_THREE(3, 5000),
    MATCH_COUNT_TWO(2, 0),
    MATCH_COUNT_ONE(1, 0),
    MATCH_COUNT_ZERO(0, 0);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public int getPrize(){
        return this.prize;
    }

    public int getMatchCount(){
        return this.matchCount;
    }
}
