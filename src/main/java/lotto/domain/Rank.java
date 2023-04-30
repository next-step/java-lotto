package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

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

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean bonusMatch) {
        if (countOfMatch == SECOND.countOfMatch && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(r -> r.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(NONE);
    }

}
