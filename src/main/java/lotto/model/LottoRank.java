package lotto.model;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);


    private final long matchCount;
    private final int money;

    LottoRank(long rank, int money) {
        this.matchCount = rank;
        this.money = money;
    }

    public int money() {
        return this.money;
    }

    public long matchCount() {
        return this.matchCount;
    }

    public static LottoRank valueOf(long rank, boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return matchRank(lottoRank -> lottoRank.matchCount() == rank);
        }
        return matchRank(
            lottoRank -> lottoRank.matchCount() == rank && lottoRank != LottoRank.SECOND);
    }

    private static LottoRank matchRank(Conditional conditional) {
        return Arrays.stream(values())
            .filter(conditional::test)
            .findAny()
            .orElse(LottoRank.MISS);
    }

}
