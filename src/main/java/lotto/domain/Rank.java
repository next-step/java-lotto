package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int countOfMatchForWinning;
    private final Money winningMoney;

    Rank(int countOfMatchForWinning, long winningAmount) {
        this.countOfMatchForWinning = countOfMatchForWinning;
        this.winningMoney = Money.of(winningAmount);
    }

    public static List<Rank> winningValues() {
        return Arrays.stream(values())
                .filter(rank -> !MISS.equals(rank))
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int countOfMatch, boolean hitBonusBall) {
        if (hitBonusBall && SECOND.hasCountOfMatchForWinning(countOfMatch)) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.hasCountOfMatchForWinning(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    private boolean hasCountOfMatchForWinning(int countOfMatch) {
        return countOfMatchForWinning == countOfMatch;
    }

    public int getCountOfMatchForWinning() {
        return countOfMatchForWinning;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }
}
