package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private int hit;
    private int prize;

    Rank(int hit, int prize) {
        this.hit = hit;
        this.prize = prize;
    }

    public int wins() {
        return this.prize;
    }

    public static Rank of(int numberOfIdentical) {
        return Arrays.stream(values())
                .filter(rank -> isRank(rank, numberOfIdentical))
                .findFirst()
                .orElseGet(() -> NONE);
    }

    private static boolean isRank(Rank rank, int numberOfIdentical) {
        return rank.hit == numberOfIdentical;
    }
}
