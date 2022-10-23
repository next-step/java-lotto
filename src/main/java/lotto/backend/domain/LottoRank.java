package lotto.backend.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NOTHING(0, 0);

    private final int match;
    private final double prize;

    LottoRank(int match, double prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoRank of(int match) {
        return Arrays.stream(LottoRank.values())
                .filter(item -> item.getMatch() == match)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMatch() {
        return this.match;
    }

    public double getPrize() {
        return this.prize;
    }
}
