package lotto.domain;

import java.util.Arrays;

public enum Rank {
    LOSE(0, 0),
    FIFTH(5_000, 3),
    FORTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_0000, 5, true),
    FIRST(2_000_000_000, 6);

    private final int prize;
    private final int countOfMatch;
    private final boolean matchBonus;

    Rank(int prize, int countOfMatch) {
        this(prize, countOfMatch, false);
    }

    Rank(int prize, int countOfMatch, boolean matchBonus) {
        this.prize = prize;
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public int prize() {
        return prize;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public boolean matchBonus() {
        return matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(countOfMatch, matchBonus))
                .reduce((first, second) -> second)
                .orElse(LOSE);
    }

    private boolean isMatch(int countOfMatch, boolean matchBonus) {
        if (this.countOfMatch != countOfMatch) {
            return false;
        }

        return isMatchBonus(matchBonus);
    }

    private boolean isMatchBonus(boolean matchBonus) {
        if (!this.matchBonus)
            return true;
        return matchBonus;
    }
}
