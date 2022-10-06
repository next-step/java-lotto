package lottogame.domain.enums;

import java.util.Arrays;

import lottogame.domain.Money;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), 6),
    THIRD(new Money(1_500_000), 5),
    FOURTH(new Money(50_000), 4),
    FIFTH(new Money(5_000), 3),
    NONE(new Money(0), 0);

    private final Money reward;
    private final int rankConditionCount;

    LottoGameRank(Money reward, int rankConditionCount) {
        this.reward = reward;
        this.rankConditionCount = rankConditionCount;
    }

    public static LottoGameRank findRank(int sameNumberCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.rankConditionCount == sameNumberCount)
            .findFirst()
            .orElse(LottoGameRank.NONE);
    }

    public Money getReward() {
        return reward;
    }

    public int getMinimumMatchNumberCount() {
        return rankConditionCount;
    }
}
