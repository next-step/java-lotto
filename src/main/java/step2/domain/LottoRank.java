package step2.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, new Money(2_000_000_000L), 1, "6개 일치 (2000000000원)"),
    SECOND(5, new Money(3_000_000L), 2, "5개 일치, 보너스 볼 일치 (3000000원)"),
    THIRD(5, new Money(1_500_000L), 3, "5개 일치 (1500000원)"),
    FOURTH(4, new Money(50_000L), 4, "4개 일치 (50000원)"),
    FIFTH(3, new Money(5_000L), 5, "3개 일치 (5000원)"),
    NO_RANK(2, new Money(0L), 6, "");

    private final Integer matchCount;
    private final Money money;
    private final Integer rank;
    private final String etc;

    LottoRank(Integer matchCount, Money money, Integer rank, String etc) {
        this.matchCount = matchCount;
        this.money = money;
        this.rank = rank;
        this.etc = etc;
    }

    public static LottoRank matchOf(final int matchCount) {
        return Arrays.stream(LottoRank.values())
                     .filter(lottoRank -> lottoRank.matchCount == matchCount)
                     .findFirst()
                     .orElse(NO_RANK);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Money getMoney() {
        return money;
    }

    public String getEtc() {
        return etc;
    }
}
