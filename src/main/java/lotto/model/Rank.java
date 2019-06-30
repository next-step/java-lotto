package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.valueOf(2_000_000_000)),
    SECOND(5, Money.valueOf(30_000_000)),
    THIRD(5, Money.valueOf(1_500_000)),
    FOURTH(4, Money.valueOf(50_000)),
    FIFTH(3, Money.valueOf(5_000)),
    MISS(0, Money.valueOf(0));

    private Money winningMoney;
    private int countOfMatch;

    Rank(int countOfMatch, Money winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public Money getWinningMoney(int count) {
        return winningMoney.multiple(count);
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}

