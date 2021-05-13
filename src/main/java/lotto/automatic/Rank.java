package lotto.automatic;

import java.util.Arrays;
import java.util.Objects;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_VALUE_MSG = "값이 잘못되었습니다. 다시 한번 확인해주세요.";

    private int winningNumber, money;

    Rank(int winningNumber, int money) {
        this.winningNumber = winningNumber;
        this.money = money;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public int getMoney() {
        return money;
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.matchCountToRank(matchCount,bonus))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_VALUE_MSG));
    }

    private Rank matchCountToRank(int matchCount, boolean bonus) {
        for (Rank prizelist : values()) {
            if (matchCount < WINNING_MIN_COUNT) {
                return MISS;
            }
            if (THIRD.getWinningNumber() == matchCount && !bonus) {
                return THIRD;
            }
            if (prizelist.getWinningNumber() == matchCount) {
                return prizelist;
            }
        }
        throw new IllegalArgumentException(ERROR_VALUE_MSG);
    }
}
