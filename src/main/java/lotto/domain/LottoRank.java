package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    NO_PLACE(0, 0);

    protected final int MATCH_COUNT;
    protected final long AMOUNT;

    LottoRank(int matchCount, long amount) {
        MATCH_COUNT = matchCount;
        AMOUNT = amount;
    }

    public static LottoRank of(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.MATCH_COUNT == matchCount)
                .findFirst()
                .orElse(NO_PLACE);
    }

    public int getMATCH_COUNT() {
        return MATCH_COUNT;
    }

    public long getAMOUNT() {
        return AMOUNT;
    }
}
