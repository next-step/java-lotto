package lotto.domain;

import java.util.Arrays;
import java.util.List;

/**
 * @author han
 */
public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    public static List<Rank> wonRanks = Arrays.asList(FIFTH, FORTH, THIRD, SECOND, FIRST);

    private int match;
    private int money;

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public static Rank of(int count, boolean bonus) {
        if (count == Rank.SECOND.match && bonus) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.SECOND)
            .filter(rank -> rank.match == count)
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
