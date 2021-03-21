package study.step2.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int amount;
    private final int hit;

    LottoRank(int hit, int amount) {
        this.hit = hit;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getHit() {
        return this.hit;
    }

    public static LottoRank of(int hit) {
        return Arrays.stream(LottoRank.values())
            .filter(resultType -> resultType.hit == hit)
            .findFirst()
            .orElse(MISS);
    }
}
