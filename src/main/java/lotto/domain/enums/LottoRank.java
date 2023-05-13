package lotto.domain.enums;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NO_RANK(0, false, 0);

    private int matchedCount;
    private boolean bonusMatched;
    private int prizeMoney;

    LottoRank(int matchingCount, boolean bonusMatched, int prizeMoney) {
        this.matchedCount = matchingCount;
        this.bonusMatched = bonusMatched;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findByMatchedCount(int count, boolean bonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(lotteRank -> lotteRank.matchedCount == count && lotteRank.bonusMatched == bonusMatched)
                .findAny()
                .orElse(LottoRank.NO_RANK);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }
}

