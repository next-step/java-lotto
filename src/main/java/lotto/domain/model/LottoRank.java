package lotto.domain.model;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank of(int countOfMatch, boolean matchBonus) {
        if (isMiss(countOfMatch)) {
            return MISS;
        }
        if (isSecond(countOfMatch, matchBonus)) {
            return SECOND;
        }
        if (isThird(countOfMatch, matchBonus)) {
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean isMiss(int countOfMatch) {
        return countOfMatch < FIFTH.countOfMatch;
    }

    private static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return countOfMatch == SECOND.countOfMatch && matchBonus;
    }

    private static boolean isThird(int countOfMatch, boolean matchBonus) {
        return countOfMatch == THIRD.countOfMatch && !matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
