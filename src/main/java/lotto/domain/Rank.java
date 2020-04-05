package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSER(0, 0);

    public static final int WINNING_COUNT_BOUNDARY = 3;

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return Stream.of(values())
                .filter(rank -> rank.isMatched(matchCount))
                .filter(rank -> !rank.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(LOSER);
    }

    private boolean isMatched(int matchCount) {
        return getMatchCount() == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
