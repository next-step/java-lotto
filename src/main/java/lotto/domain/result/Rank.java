package lotto.domain.result;

import lotto.domain.money.Money;

import java.util.Arrays;

public enum Rank {

    NONE(0, Money.of(0)),
    FIFTH(3, Money.of(5_000)),
    FOURTH(4, Money.of(50_000)),
    THIRD(5, Money.of(1_500_000)),
    SECOND(5, Money.of(30_000_000)),
    FIRST(6, Money.of(2_000_000_000)),
    ;

    private final long matchCount;
    private final Money money;


    Rank(long matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank findRankBy(long matchCount, boolean bonusMatch) {
        if (isSecond(matchCount, bonusMatch)) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(Rank::isNotSecond)
                .filter(r -> isSameMatchCount(matchCount, r))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isSecond(long matchCount, boolean bonusMatch) {
        return matchCount == SECOND.matchCount && bonusMatch;
    }

    private static boolean isNotSecond(Rank rank) {
        return rank != SECOND;
    }

    private static boolean isSameMatchCount(long matchCount, Rank r) {
        return r.matchCount == matchCount;
    }

    public long getPrizeAmount() {
        return money.getAmount();
    }

    public long getMatchCount() {
        return matchCount;
    }

}
