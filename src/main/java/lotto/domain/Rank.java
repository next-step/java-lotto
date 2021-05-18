package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_VALUE_MSG = "값이 잘못되었습니다. 다시 한번 확인해주세요.";

    private int winningCount, money;

    Rank(int winningCount, int money) {
        this.winningCount = winningCount;
        this.money = money;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public static Rank getRank(int winningOfNumber, boolean bonus) {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.matchCountToRank(winningOfNumber, bonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_VALUE_MSG));
    }

    private Rank matchCountToRank(int winningOfNumber, boolean bonus) {
        for (Rank rank : values()) {
            if (winningOfNumber < WINNING_MIN_COUNT) {
                return MISS;
            }
            if (THIRD.getWinningCount() == winningOfNumber && !bonus) {
                return THIRD;
            }
            if (rank.getWinningCount() == winningOfNumber) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR_VALUE_MSG);
    }

}
