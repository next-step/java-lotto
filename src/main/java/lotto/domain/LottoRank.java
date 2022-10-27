package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum LottoRank {

    FIRST(6, 2_000_000_000, 4),
    SECOND(5, 30_000_000, 3),
    THIRD(5, 1_500_000, 2),
    FOURTH(4, 50_000, 1),
    FIFTH(3, 5_000, 0),
    NONE(null,0, null);

    final private Integer matchCount;
    final private long prize;
    final private Integer displayOrder;

    LottoRank(Integer matchCount, long prize, Integer displayOrder) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.displayOrder = displayOrder;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    public static LottoRank getRank(int count, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.isNonNullAndEqualTo(count))
            .filter(lottoRank -> lottoRank.checkBonusMatch(bonusMatch))
            .findAny()
            .orElse(NONE);
    }

    private boolean isNonNullAndEqualTo(int count) {
        return Objects.nonNull(matchCount) && matchCount.equals(count);
    }

    private boolean checkBonusMatch(boolean bonusMatch) {
        if (this == SECOND) {
            return bonusMatch;
        }

        if (this == THIRD) {
            return !bonusMatch;
        }

        return true;
    }
}
