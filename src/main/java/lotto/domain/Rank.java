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

    private final int countOfMath;
    private final int winningPrize;

    Rank(int countOfMath, int winningPrize) {
        this.countOfMath = countOfMath;
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static int countOfMatch(Rank rank) {
        return rank.countOfMath;
    }

    public static Rank valueOf(int countOfMath) {
        return Arrays.stream(Rank.values())
                .filter(rank -> countOfMatch(rank) == countOfMath)
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
