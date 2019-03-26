package lotto.domain;

import java.util.Arrays;

public enum WinMoney {

  THREE(3, false, 5_000),
  FOUR(4, false, 50_000),
  FIVE(5, false, 1_500_000),
  FIVE_ONE(5, true, 30_000_000),
  SIX(6, false, 2_000_000_000),
  ;

  private long matchCount;
  private boolean hasBonus;
  private long winMoney;

  WinMoney(long matchCount, boolean hasBonus, long winMoney) {
    this.matchCount = matchCount;
    this.hasBonus = hasBonus;
    this.winMoney = winMoney;
  }

  public long getMatchCount() {
    return matchCount;
  }

  public long getWinMoney() {
    return winMoney;
  }

  public static WinMoney of(long matchCount, boolean hasBonus) {

    return Arrays.stream(WinMoney.values())
        .filter(winMoney -> winMoney.matchCount == matchCount && winMoney.hasBonus == hasBonus)
        .findFirst()
        .orElse(null);
  }

  public Money totalWinMoney(long winCount) {
    return new Money(this.winMoney * winCount);
  }
}
