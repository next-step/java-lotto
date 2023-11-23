package lotto.domain;

public enum Rank {
    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int countOfMatch;
    private final long prizeMoney;

    Rank(int countOfMatch, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valeOf(int countOfMatch) {
        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return NOTHING;
    }
}
