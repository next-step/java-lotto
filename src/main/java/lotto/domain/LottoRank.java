package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {
    FIRST(6, false, new Money(2_000_000_000)),
    SECOND(5, true, new Money(30_000_000)),
    THIRD(5, false, new Money(1_500_000)),
    FOURTH(4, false, new Money(50_000)),
    FIFTH(3, false, new Money(5_000)),
    NO_RANK(0, false, Money.ZERO)
    ;

    private final int matchCount;
    private final boolean requiresBonusMatch;
    private final Money prize;

    LottoRank(int matchCount, boolean requiresBonusMatch, Money prize) {
        this.matchCount = matchCount;
        this.requiresBonusMatch = requiresBonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonusMatch() {
        return requiresBonusMatch;
    }

    public Money getPrize() {
        return prize;
    }

    public static LottoRank findRank(int matchCount, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() <= matchCount)
                .filter(lottoRank -> !lottoRank.isRequiresBonusMatch() || bonusMatch)
                .max(Comparator.comparing(LottoRank::getPrize))
                .orElseThrow();
    }

}

