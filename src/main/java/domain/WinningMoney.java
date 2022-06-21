package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class WinningMoney {
    private final Cash winningMoney;

    public WinningMoney(Cash winningMoney) {
        this.winningMoney = winningMoney;
    }

    public WinningMoney(int winningMoney) {
        this.winningMoney = new Cash(winningMoney);
    }

    public static WinningMoney of(CountByRank countByRank) {
        WinningMoney winningMoney = new WinningMoney(0);
        for (Rank rank : Rank.values()) {
            winningMoney = winningMoney.add(winningMoneyByRank(countByRank, rank));
        }
        return winningMoney;
    }

    public BigDecimal toRate(Cash cash) {
        return winningMoney.divide(cash);
    }

    public WinningMoney add(WinningMoney winningMoney) {
        return new WinningMoney(this.winningMoney.add(winningMoney.toCash()));
    }

    public WinningMoney multiply(int count) {
        return new WinningMoney(winningMoney.multiply(count));
    }

    public Cash toCash() {
        return winningMoney;
    }

    private static WinningMoney winningMoneyByRank(CountByRank countByRank, Rank rank) {
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

    @Override
    public String toString() {
        return String.valueOf(winningMoney);
    }
}
