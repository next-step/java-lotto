package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),

    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueByCount(final int countOfMatch) {
        return Stream.of(Rank.values())
            .filter(rank -> rank.countOfMatch == countOfMatch)
            .findFirst()
            .orElse(MISS);
    }

    public static List<Rank> rankValues() {
        return Arrays.asList(Rank.values()).stream()
            .filter(lottoMatch -> lottoMatch != Rank.MISS)
            .collect(Collectors.toList());
    }
}
