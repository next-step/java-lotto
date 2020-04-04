package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSER(0, 0);

    public static final int WINNING_COUNT_BOUNDARY = 3;

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank of(int matchCount) {
        if (matchCount < WINNING_COUNT_BOUNDARY) {
            return LOSER;
        }

        return Stream.of(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 랭킹입니다."));
    }
}
