package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningPrize;

    Rank(int countOfMath, int winningPrize) {
        this.countOfMatch = countOfMath;
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public static boolean equalsCountOfMatch(Rank rank, int count) {
        return count == rank.countOfMatch;
    }

    public static Rank valueOf(int count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> equalsCountOfMatch(rank, count))
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
