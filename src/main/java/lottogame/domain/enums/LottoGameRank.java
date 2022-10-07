package lottogame.domain.enums;

import java.util.Arrays;

import lottogame.domain.Money;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), 6, false),
    SECOND(new Money(30_000_000), 5, true),
    THIRD(new Money(1_500_000), 5, false),
    FOURTH(new Money(50_000), 4, false),
    FIFTH(new Money(5_000), 3, false),
    NONE(new Money(0), 0, false);

    private final Money reward;
    private final int rankConditionCount;
    private final boolean hasBonusCondition;

    LottoGameRank(Money reward, int rankConditionCount, boolean hasBonusCondition) {
        this.reward = reward;
        this.rankConditionCount = rankConditionCount;
        this.hasBonusCondition = hasBonusCondition;
    }

    public static LottoGameRank findRank(int sameNumberCount, boolean hasSameBonusNumber) {
        return Arrays.stream(values())
            .filter(rank -> satisfyCondition(rank, sameNumberCount, hasSameBonusNumber))
            .findFirst()
            .orElse(LottoGameRank.NONE);
    }

    private static boolean satisfyCondition(LottoGameRank rank, int sameNumberCount, boolean hasSameBonusNumber) {
        if (rank.hasBonusCondition) {
            return rank.rankConditionCount == sameNumberCount && hasSameBonusNumber;
        }

        return rank.rankConditionCount == sameNumberCount;
    }

    public Money getReward() {
        return reward;
    }

    public int getMinimumMatchNumberCount() {
        return rankConditionCount;
    }
}
