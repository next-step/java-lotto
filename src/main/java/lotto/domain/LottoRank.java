package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    public static final List<LottoRank> RANKS_WITHOUT_NONE = Arrays.asList(FOURTH, THIRD, SECOND, FIRST);

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

    public static LottoRank of(int equalNumberCount, boolean hasBonusNumber) {
        if (equalNumberCount < FIFTH.equalNumberCount) {
            return NONE;
        }

        LottoRank lottoRank = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.equalNumberCount == equalNumberCount)
                .findFirst()
                .orElse(NONE);

        if (lottoRank == SECOND && !hasBonusNumber) {
            return THIRD;
        }

        return lottoRank;
    }
}
