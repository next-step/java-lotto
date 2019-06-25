package lotto.domain;

import java.util.Arrays;

public enum Rank {
  MISS(0, 0),
  FIFTH(3, 5_000),
  FOURTH(4, 50_000),
  THIRD(5, 1_500_000),
  FIRST(6, 2_000_000_000);

  private int countOfMatch;
  private int winningMoney;

  private Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public static Rank getInstance(long countOfMatch) {
    return Arrays.stream(Rank.values())
        .filter(rank -> countOfMatch == rank.countOfMatch)
        .findAny()
        .orElse(Rank.MISS);
  }
}
