package lotto.common;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;

import java.util.List;

public enum Rank {
    FIRST(6, asList(true, false), 2_000_000_000),
    SECOND(5, singletonList(true), 30_000_000),
    THIRD(5, singletonList(false), 1_500_000),
    FOURTH(4, asList(true, false), 50_000),
    FIFTH(3, asList(true, false), 5_000),
    MISS(0, asList(true, false), 0);

    private final int countOfMatch;
    private final List<Boolean> matchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, List<Boolean> matchBonus, int winningMoney) {
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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return stream(Rank.values())
            .filter(r -> r.countOfMatch == countOfMatch && r.matchBonus.contains(matchBonus))
            .findFirst()
            .orElse(MISS);
    }
}
