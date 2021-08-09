package lotto.service;

import java.util.stream.Stream;

public enum Rank {
  FIRST(6, 2_000_000_000 ,false),
  SECOND(5, 30_000_000,true),
  THIRD(5, 1_500_000,false),
  FOURTH(4, 50_000,false),
  FIFTH(3, 5_000,false),
  MISS(0, 0,false);

  private final int countOfMatch;
  private final int winningMoney;
  private final boolean matchBonus;

  Rank(int countOfMatch, int winningMoney, Boolean matchBonus) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
    this.matchBonus = matchBonus;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public static Rank matchRank(int countOfMatch) {
    return Stream.of(values())
        .filter(rank -> (rank.countOfMatch == countOfMatch))
        .findFirst()
        .orElse(MISS);
  }

  public static Rank matchRank(int countOfMatch, boolean matchBonus) {
    return Stream.of(values())
        .filter(rank -> (rank.countOfMatch == countOfMatch))
        .filter(rank -> rank.matchBonus == matchBonus)
        .findFirst()
        .orElse(MISS);
  }

}
