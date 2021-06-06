package lotto.domain.entity;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, new BigDecimal("2000000000"), false),
    SECOND(5, new BigDecimal("30000000"), true),
    THIRD(5, new BigDecimal("1500000"), false),
    FOURTH(4, new BigDecimal("50000"), false),
    FIFTH(3, new BigDecimal("5000"), false),
    MISS(0, new BigDecimal("0"), false);

    private final int countOfMatch;
    private final BigDecimal winningMoney;
    private final boolean matchBonus;

    Rank(int countOfMatch, BigDecimal winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    private int countOfMatch() {
        return countOfMatch;
    }

    private boolean matchBonus() {
        return matchBonus;
    }

    public BigDecimal winningMoney() {
        return winningMoney;
    }

    public static Rank valueOfCountWithMatchBonus(int count, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch() == count && rank.matchBonus() == isMatchBonus(rank, matchBonus))
                .findAny()
                .orElse(Rank.MISS);
    }

    private static boolean isMatchBonus(Rank rank, boolean matchBonus) {
        return rank.countOfMatch() == 5 && matchBonus;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + countOfMatch +
                ", winningMoney=" + winningMoney +
                ", matchBonus=" + matchBonus +
                '}';
    }
}
