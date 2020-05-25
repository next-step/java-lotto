package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),

    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;

    Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Stream.of(Rank.values())
            .filter(
                rank -> rank.countOfMatch == countOfMatch &&
                    (!rank.matchBonus || matchBonus)
            )
            .findFirst()
            .orElse(MISS);
    }

    public static List<Rank> rankValues() {
        return Arrays.asList(Rank.values()).stream()
            .filter(lottoMatch -> lottoMatch != Rank.MISS)
            .collect(Collectors.toList());
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
