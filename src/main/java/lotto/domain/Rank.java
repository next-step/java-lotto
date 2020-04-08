package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private int countOfMatch;
    private boolean matchBonus;
    private int winningMoney;

    private Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCondition(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatchCondition(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5) {
            return Objects.equals(this.countOfMatch, countOfMatch)
                    && Objects.equals(this.matchBonus, matchBonus);
        }
        return Objects.equals(this.countOfMatch, countOfMatch);
    }
}
