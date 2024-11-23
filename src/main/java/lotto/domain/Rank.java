package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    private int hit;
    private int prize;
    private boolean hasBonus;

    Rank(int hit, int prize, boolean hasBonus) {
        this.hit = hit;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public int wins() {
        return this.prize;
    }

    public static Rank of(int numberOfIdentical, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> isRank(rank, numberOfIdentical, hasBonus))
                .findFirst()
                .orElseGet(() -> NONE);
    }

    private static boolean isRank(Rank rank, int numberOfIdentical, boolean hasBonus) {
        if (rank == SECOND) {
            return rank.hit == numberOfIdentical && rank.hasBonus == hasBonus;
        }

        return rank.hit == numberOfIdentical;
    }

    public int getHit() {
        return hit;
    }

    public int getPrize() {
        return prize;
    }
}
