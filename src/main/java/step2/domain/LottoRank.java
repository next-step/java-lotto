package step2.domain;

import java.util.Arrays;

public enum LottoRank {
    SIX(6, new Money(2000000000L), "1등"),
    FIVE(5, new Money(1500000L), "2등"),
    FOUR(4, new Money(50000L), "3등"),
    THREE(3, new Money(5000L), "4등"),
    NO_RANK(2, new Money(0L), "5등 이하");

    private final Integer matchCount;
    private final Money money;
    private final String rank;

    LottoRank(Integer matchCount, Money money, String rank) {
        this.matchCount = matchCount;
        this.money = money;
        this.rank = rank;
    }

    public static LottoRank matchOf(final int matchCount) {
        return Arrays.stream(LottoRank.values())
                     .filter(lottoRank -> lottoRank.matchCount == matchCount)
                     .findFirst()
                     .orElse(NO_RANK);
    }

    public Money getMoney() {
        return money;
    }
}
