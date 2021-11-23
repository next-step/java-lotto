package lotto.domain;

import java.util.Arrays;

/**
 * @author han
 */
public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    NONE(0, 0);

    private int match;
    private int money;

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public static Rank of (int count) {
        return Arrays.stream(Rank.values())
            .filter(r -> r.match == count)
            .findFirst()
            .orElse(Rank.NONE);
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

}
