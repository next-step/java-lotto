package lotto.domain.result;

import lotto.domain.money.Money;

import java.util.Arrays;

public enum Rank {

    NONE(0, Money.of(0)),
    FOURTH(3, Money.of(5_000)),
    THIRD(4, Money.of(50_000)),
    SECOND(5, Money.of(1_500_000)),
    FIRST(6, Money.of(2_000_000_000))
    ;

    private final long matchCount;
    private final Money money;

    Rank(long matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank findRank(long matchCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrizeAmount() {
        return money.getAmount();
    }

    public long getMatchCount() {
        return matchCount;
    }

}
