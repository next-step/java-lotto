package step2.domain;

public enum Rank {
    RANK_5(5_000, 3, false),
    RANK_4(50_000, 4, false),
    RANK_3(1_500_000, 5, false),
    RANK_2(30_000_000, 5, true),
    RANK_1(2_000_000_000, 6, false),
    NO_RANK(0, 0, false);

    public final int price;
    public final int matchCount;
    public final boolean bonus;

    Rank(int price, int matchCount, boolean bonus) {
        this.price = price;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static Rank of(int count, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == count && rank.bonus == bonus)
                return rank;
        }
        return NO_RANK;
    }
}
