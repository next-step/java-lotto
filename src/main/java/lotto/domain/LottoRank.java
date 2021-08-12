package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    NO_PLACE(0, 0);

    private static final LottoRank[] LOTTO_RANKS = LottoRank.values();

    private final int matchCount;
    private final long amount;
    private final boolean isBonus;

    LottoRank(final int matchCount, final long amount) {
        this(matchCount, amount, false);
    }

    LottoRank(final int matchCount, final long amount, final boolean isBonus) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.isBonus = isBonus;
    }

    public static LottoRank of(final int matchCount, final boolean isBonus) {
        LottoRank lottoRank = Arrays.stream(LOTTO_RANKS)
                .filter(rank -> !rank.isBonus)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NO_PLACE);

        if(lottoRank.equals(THIRD_PLACE) && isBonus) {
            return SECOND_PLACE;
        }
        return lottoRank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }
}
