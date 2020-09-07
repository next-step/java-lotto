package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int countOfMatch;
    private final int winningPrize;
    private final boolean isMatchBonusBall;

    Rank(int countOfMath, int winningPrize, boolean isMatchBonusBall) {
        this.countOfMatch = countOfMath;
        this.winningPrize = winningPrize;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isMatchBonusBall() {
        return isMatchBonusBall;
    }

    public static boolean equalsCountOfMatch(Rank rank, int count) {
        return count == rank.countOfMatch;
    }

    public static Rank valueOf(int count, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> equalsCountOfMatch(rank, count))
                .filter(rank -> !SECOND.equals(rank) || hasBonusNumber)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public static List<Rank> ranks() {
        return Arrays.stream(values())
                .filter(rank -> !MISS.equals(rank))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
