package step3.domain.result;

import java.util.Arrays;

public enum Rank {
  FIRST(6, 2_000_000_000),
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

  public static Rank findRankByCountOfMatch(int countOfMatch, boolean matchBonus) {

    if (countOfMatch < FIFTH.countOfMatch) {
      return MISS;
    }

    if (matchBonus & countOfMatch == SECOND.countOfMatch) {
      return SECOND;
    }

    if (!matchBonus & countOfMatch == THIRD.countOfMatch) {
      return THIRD;
    }

    return findRankByCountOfMatch(countOfMatch);
  }

  private static Rank findRankByCountOfMatch(int countOfMatch) {
    return Arrays.stream(values()).filter(rank -> rank.countOfMatch == countOfMatch).findFirst().orElse(MISS);
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }
}
