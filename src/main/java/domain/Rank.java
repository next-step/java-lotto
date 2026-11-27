package domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean requiresBonus;

    Rank(int countOfMatch, int winningMoney, boolean requiresBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.requiresBonus = requiresBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public static List<Rank> winningRanks() {
        return Arrays.stream(values())
                .filter(rank -> rank != MISS)
                .toList();
    }

    public long prize(int count) {
        return (long) winningMoney * count;
    }


    public static Rank valueOf(MatchCount matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean matches(MatchCount matchCount, boolean matchBonus) {
        return matchCount.isSame(countOfMatch) && (!requiresBonus || matchBonus);
    }


}
