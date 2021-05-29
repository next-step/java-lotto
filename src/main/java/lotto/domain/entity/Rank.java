package lotto.domain.entity;

import java.math.BigDecimal;

public enum Rank {
    FIRST(6, new BigDecimal("2000000000")),
    SECOND(5, new BigDecimal("30000000")),
    THIRD(5, new BigDecimal("1500000")),
    FOURTH(4, new BigDecimal("50000")),
    FIFTH(3, new BigDecimal("5000"));

    private final int countOfMatch;
    private final BigDecimal winningMoney;

    Rank(int countOfMatch, BigDecimal winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public BigDecimal winningMoney() {
        return winningMoney;
    }
}
