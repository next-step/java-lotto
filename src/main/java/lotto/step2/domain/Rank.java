package lotto.step2.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "꽝"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final long hit;
    private final long amount;
    private final String message;

    Rank(long hit, long amount, String message) {
        this.hit = hit;
        this.amount = amount;
        this.message = message;
    }

    public static Rank from(long hit, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> {
                    if (hit == 5) {
                        return (bonusNumber ? rank.amount == 30_000_000 : rank.amount == 1_500_000);
                    }
                    return rank.hit == hit;
                })
                .findFirst()
                .orElse(MISS);
    }

    public long amount() {
        return this.amount;
    }

    public long hit() {
        return this.hit;
    }

    public String message() {
        return this.message;
    }

}
