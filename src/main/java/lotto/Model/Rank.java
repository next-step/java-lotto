package lotto.Model;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    OTHER(0, 0);

    private static final int CANDIDATE_BONUS_COUNT = 5;

    private final int matches;
    private final int profit;

    Rank(int matches, int profit) {
        this.matches = matches;
        this.profit = profit;
    }

    public static Rank of(int matches, boolean matchBonus) {
        if (matches == CANDIDATE_BONUS_COUNT && matchBonus) {
            return SECOND;
        }
        return of(matches);
    }

    public static Rank of(int matches) {
        for (Rank rank : Rank.values()) {
            if (rank.matches == matches) {
                return rank;
            }
        }
        return OTHER;
    }

    public int matches() {
        return matches;
    }

    public int profit() {
        return profit;
    }
}
