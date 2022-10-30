package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 1_500_000),
    THIRD(5, false, 50_000),
    FORTH(4, null, 5_000),
    NON_MATCH(0, null, 0);

    private final int count;
    private final Boolean matchBonus;
    private final int prize;

    Rank(int count, Boolean matchBonus, int prize) {
        this.count = count;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank match(int count, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> isMatch(rank, count, matchBonus))
                .findFirst()
                .orElse(NON_MATCH);
    }

    private static boolean isMatch(Rank rank, int count, boolean matchBonus) {
        if (rank.matchBonus != null) {
            return rank.count == count && rank.matchBonus.equals(matchBonus);
        }
        return rank.count == count;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }
}
