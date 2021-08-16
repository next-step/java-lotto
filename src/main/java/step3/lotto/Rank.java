package step3.lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final long countOfMatch;
    private final long prizeMoney;

    Rank(long countOfMatch, long prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(long countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> findByCountOfMatch(rank, countOfMatch))
                .map(rank -> convertIfThird(rank, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean findByCountOfMatch(Rank rank, long countOfMatch) {
        return rank.getCountOfMatch() == countOfMatch;
    }

    private static Rank convertIfThird(Rank rank, boolean matchBonus) {
        if (isThird(rank, matchBonus))
            return THIRD;
        return rank;
    }

    private static boolean isThird(Rank rank, boolean matchBonus) {
        return rank == SECOND && !matchBonus;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
