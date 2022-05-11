package lotto.domain;

import lotto.exception.WrongLottoMatchCountException;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int sumRankMoney(int money) {
        return this.winningMoney + money;
    }

    public static Rank valueOf(int countOfMatch) {
        return valueOf(countOfMatch, false);
    }

    public static Rank valueOf(int countOfMatch, boolean isBonus) {
        validate(countOfMatch);

        if (isSecond(countOfMatch, isBonus)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(r -> r.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private static void validate(int countOfMatch) {
        if (countOfMatch < MISS.countOfMatch || countOfMatch > FIRST.countOfMatch) {
            throw new WrongLottoMatchCountException();
        }
    }

    private static boolean isSecond(int countOfMatch, boolean isBonus) {
        return countOfMatch == SECOND.countOfMatch && isBonus;
    }
}
