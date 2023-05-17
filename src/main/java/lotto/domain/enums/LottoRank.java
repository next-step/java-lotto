package lotto.domain.enums;

import lotto.domain.Money;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NO_RANK(0, false, 0);

    private int matchedCount;
    private boolean bonusMatched;
    private Money prizeMoney;

    LottoRank(int matchingCount, boolean bonusMatched, long prizeMoney) {
        this.matchedCount = matchingCount;
        this.bonusMatched = bonusMatched;
        this.prizeMoney = new Money(prizeMoney);
    }

    public static LottoRank findByMatchedCount(int count, boolean bonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(lotteRank -> lotteRank.matchedCount == count
                        && (lotteRank.bonusMatched == bonusMatched || lotteRank.bonusMatched == false))
                .findFirst()
                .orElse(LottoRank.NO_RANK);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    public Money getPrizeMoney(int count) {
        return prizeMoney.multiply(count);
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }
}

