package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(-1, 0);

    public static final List<LottoRank> RANKS_WITHOUT_NONE = Arrays.asList(FIRST, SECOND, THIRD, FOURTH);

    public final int equalNumberCount;
    public final int prizeMoneyAmount;

    LottoRank(int equalNumberCount, int prizeMoneyAmount) {
        this.equalNumberCount = equalNumberCount;
        this.prizeMoneyAmount = prizeMoneyAmount;
    }

    public static LottoRank fromEqualNumberCount(int equalNumberCount) {
        if (equalNumberCount < FOURTH.equalNumberCount) {
            return NONE;
        }

        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.equalNumberCount == equalNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public static int findPrizeMoneyFromEqualNumberCount(int equalNumberCount) {
        LottoRank rank = fromEqualNumberCount(equalNumberCount);
        return rank.prizeMoneyAmount;
    }
}
