package lotto.domain;

import lotto.exception.NotFoundRankException;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    NOTHING(0, 0);

    int matchCount;
    int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank from(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new NotFoundRankException(matchCount));
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int price() {
        return this.money;
    }
}
