package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningRank {

    FIRST(6, 2_000_000_000),

    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int moneyOfPrize;

    WinningRank(int countOfMatch, int moneyOfPrize) {
        this.countOfMatch = countOfMatch;
        this.moneyOfPrize = moneyOfPrize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getMoneyOfPrize() {
        return moneyOfPrize;
    }

    public static WinningRank valueOf(int matchCount) {
        return valueOf(matchCount, false);
    }
    public static WinningRank valueOf(int matchCount, Boolean isBonusNumberMatching ) {

        if (matchCount == SECOND.countOfMatch) {
            return isBonusNumberMatching  ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static List<WinningRank> validRanks() {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .sorted(Comparator.comparing(WinningRank::getCountOfMatch)
                        .thenComparing(rank -> rank == WinningRank.SECOND))
                .collect(Collectors.toList());
    }
}
