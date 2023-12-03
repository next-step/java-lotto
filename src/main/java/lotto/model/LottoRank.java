package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(1, LottoCondition.FIRST,2_000_000_000),
    SECOND(2, LottoCondition.SECOND,30_000_000),
    THIRD(3, LottoCondition.THIRD,1_500_000),
    FOURTH(4, LottoCondition.FOURTH,50_000),
    FIFTH(5, LottoCondition.FIFTH,5_000),
    LAST(6, LottoCondition.LAST,0);

    private static final String ERR_INVALID_RANK = "Invalid rank";
    private final int rank;
    private final LottoCondition condition;
    private final int cashPrize;

    LottoRank(int rank, LottoCondition condition, int cash) {
        this.rank = rank;
        this.condition = condition;
        this.cashPrize = cash;
    }

    public static LottoRank getByCondition(LottoCondition condition) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.equals(condition))
                .findFirst()
                .orElse(LottoRank.LAST);
    }

    public static LottoRank getByRank(int rank) {
        return Arrays.stream(values())
                .filter(element -> element.rank() == rank)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_RANK));
    }

    public boolean isSecondRank() {
        return this == LottoRank.SECOND;
    }

    public int rank() {
        return this.rank;
    }

    public LottoCondition condition() {
        return this.condition;
    }

    public int cashPrize() {
        return this.cashPrize;
    }
}
