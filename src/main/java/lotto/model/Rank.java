package lotto.model;

import lotto.model.gameresult.MatchingResult;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    GGWANG(0, 0);

    private int matchCount;
    private long cashPrize;

    Rank(int matchCount, long cashPrize) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
    }


    public static Rank findMatchResult(int matchingCount, boolean hasBonusball){
       return Arrays.stream(Rank.values())
                .filter(it -> it.isSameMatchCount(matchingCount))
                .map(it -> hasBonusball && matchingCount == 5 ? SECOND : it)
                .findFirst()
                .orElse(GGWANG);
    }

    private boolean isSameMatchCount(int matchCount){
        return this.matchCount == matchCount;
    }

    public Money calculatePrizeMoney(long count) {
        if (count == 0) {
            return new Money();
        }

        return new Money(count * cashPrize);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getCashPrize() {
        return cashPrize;
    }
}