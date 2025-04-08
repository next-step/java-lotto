package domain.Lotto;

import java.util.Arrays;

// Lotto Rank Enum
public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean matchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus)
                .findFirst()
                .orElseGet(() -> Arrays.stream(values())
                        .filter(rank -> rank.countOfMatch == countOfMatch && !rank.matchBonus)
                        .findFirst()
                        .orElse(MISS));
    }
}