package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final long amount;
    private final int hit;

    LottoRank(int hit, int amount) {
        this.hit = hit;
        this.amount = amount;
    }

    public static LottoRank of(int hit) {
        return Arrays.stream(LottoRank.values())
            .filter(resultType -> resultType.hit == hit)
            .findFirst()
            .orElse(MISS);
    }

    public static LottoRank of(int hit, boolean hitBonus) {
        LottoRank lottoRank = of(hit);

        if (lottoRank == LottoRank.SECOND && !hitBonus) {
            lottoRank = LottoRank.THIRD;
        }
        return lottoRank;
    }

    public long amount() {
        return this.amount;
    }

    public int hit() {
        return this.hit;
    }
}
