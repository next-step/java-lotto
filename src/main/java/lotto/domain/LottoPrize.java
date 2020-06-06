package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    MATCH_THIRD(3, 5000),
    MATCH_FOURTH(4, 50000),
    MATCH_FIFTH(5, 1500000),
    MATCH_SIXTH(6, 2000000000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int prize;

    LottoPrize(int countOfMatch, int prize) {
        this.countOfMatch =countOfMatch;
        this.prize = prize;
    }

    public static LottoPrize valueOf(int countLotto) {
        return Arrays.stream(LottoPrize.values())
                .filter(v -> v.getCountOfMatch() == countLotto)
                .findFirst()
                .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }
}
