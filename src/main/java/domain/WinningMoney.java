package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class WinningMoney {
    private final Cash winningMoney;

    public WinningMoney(Cash winningMoney) {
        this.winningMoney = winningMoney;
    }

    public static WinningMoney of(CountByRank countByRank) {
        Cash winningMoney = new Cash(0);
        for (Rank rank : Rank.values()) {
            winningMoney = winningMoney.add(winningMoneyByRank(countByRank, rank));
        }
        return new WinningMoney(winningMoney);
    }

    public BigDecimal toRate(Cash cash) {
        return winningMoney.divide(cash).toBigDecimal();
    }

    private static Cash winningMoneyByRank(CountByRank countByRank, Rank rank) {
        int count = countByRank.count(rank);
        return rank.getWinningMoney().multiply(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningMoney that = (WinningMoney) o;
        return winningMoney.equals(that.winningMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningMoney);
    }
}
