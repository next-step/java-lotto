package lotto.step2.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "꽝"),
    FOURTH(3, 5_000, "3개 번호 일치"),
    THIRD(4, 50_000, "4개 번호 일치"),
    SECOND(5, 1_500_000, "5개 번호 일치"),
    FIRST(6, 2_000_000_000, "6개 번호 일치");
    
    private final long hit;
    private final long amount;

    Rank(long hit, long amount, String message) {
        this.hit = hit;
        this.amount = amount;
    }

    public static Rank from(long hit) {
        return Arrays.stream(values())
                .filter(rank -> rank.hit == hit)
                .findFirst()
                .orElse(MISS);
    }

    public long amount() {
        return this.amount;
    }

    public long hit() {
        return this.hit;
    }

}
