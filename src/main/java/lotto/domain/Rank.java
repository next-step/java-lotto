package lotto.domain;

import lotto.exception.WrongLottoMatchCountException;

import java.util.Arrays;

public enum Rank {
    MISS(0, new Money(0)),
    FIFTH(3, new Money(5_000)),
    FOURTH(4, new Money(50_000)),
    THIRD(5, new Money(1_500_000)),
    SECOND(5, new Money(30_000_000)),
    FIRST(6, new Money(2_000_000_000));

    private final int countOfMatch;
    private final Money winningMoney;

    Rank(int countOfMatch, Money winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public Money sumWinningMoney(Money money) {
        return getWinningMoney().sumMoney(money);
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
