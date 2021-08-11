package lotto.service;

import java.util.stream.Stream;

public enum Rank {
  FIRST(6, 2_000_000_000 ),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int countOfMatch;
  private final int winningMoney;

  Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public static Rank matchRank(int countOfMatch, boolean matchBonus) {

    if(SECOND.getCountOfMatch() == countOfMatch && matchBonus){
      return SECOND;
    }

    if(THIRD.getCountOfMatch() == countOfMatch && !matchBonus){
      return THIRD;
    }

    return Stream.of(values())
        .filter(rank -> (rank.countOfMatch == countOfMatch))
        .findFirst()
        .orElse(MISS);
  }

}
