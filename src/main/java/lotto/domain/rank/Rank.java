package lotto.domain.rank;

import lotto.domain.Money;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.of(2_000_000_000)),
    SECOND(5, Money.of(30_000_000)),
    THIRD(5, Money.of(1_500_000)),
    FOURTH(4, Money.of(50_000)),
    FIFTH(3, Money.of(5_000)),
    NONE(0, Money.of(0)),
    ;
    
    private final int countOfMatch;
    private final Money winningMoney;

    Rank(final int countOfMatch, final Money winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(final int countOfMatch, final boolean matchBonus) {
        if (matchBonus && countOfMatch == SECOND.countOfMatch) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.SECOND)
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElse(Rank.NONE);
    }
}
