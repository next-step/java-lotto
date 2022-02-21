package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    final int match;
    final int money;

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public static Rank getReward(int matchCount, boolean bonus) {
        Rank rank = Arrays.stream(values())
            .filter(match -> match.match == matchCount)
            .findFirst()
            .orElse(NOTHING);

        if (rank.match == THIRD.match && bonus) {
            return SECOND;
        }

        return rank;
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }

    public boolean isNothing() {
        return this.equals(NOTHING);
    }
}
